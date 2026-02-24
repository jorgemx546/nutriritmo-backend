"use strict";

const express = require("express");
const bcrypt = require("bcrypt");
const jwt = require("jsonwebtoken");
const db = require("../db");

const router = express.Router();

function handleDbError(res, err, mensaje = "Error en la base de datos") {
  console.error(mensaje, err);
  return res.status(500).json({ error: mensaje });
}

// POST /api/auth/register
router.post("/register", async (req, res) => {
  try {
    const { nombre, edad, peso_inicial, altura, objetivo, email, password } = req.body;

    if (!nombre || !email || !password) {
      return res.status(400).json({ error: "Faltan datos: nombre, email y password" });
    }

    db.query("SELECT id_usuario FROM usuarios WHERE email = ?", [email], async (err, rows) => {
      if (err) return handleDbError(res, err, "Error al validar email");

      if (rows.length > 0) {
        return res.status(409).json({ error: "El correo ya está registrado" });
      }

      const password_hash = await bcrypt.hash(password, 10);

      const sql = `
        INSERT INTO usuarios (nombre, edad, peso_inicial, altura, objetivo, email, password_hash)
        VALUES (?, ?, ?, ?, ?, ?, ?)
      `;

      db.query(
        sql,
        [nombre, edad ?? null, peso_inicial ?? null, altura ?? null, objetivo ?? null, email, password_hash],
        (err2, result) => {
          if (err2) return handleDbError(res, err2, "Error al registrar usuario");

          return res.status(201).json({
            message: "Usuario registrado",
            id_usuario: result.insertId,
          });
        }
      );
    });
  } catch (e) {
    console.error(e);
    res.status(500).json({ error: "Error interno" });
  }
});

// POST /api/auth/login
router.post("/login", (req, res) => {
  const { email, password } = req.body;

  if (!email || !password) {
    return res.status(400).json({ error: "Faltan datos: email y password" });
  }

  db.query(
    "SELECT id_usuario, nombre, email, password_hash FROM usuarios WHERE email = ?",
    [email],
    async (err, rows) => {
      if (err) return handleDbError(res, err, "Error al consultar usuario");

      if (rows.length === 0) {
        return res.status(401).json({ error: "Credenciales inválidas" });
      }

      const user = rows[0];
      const ok = await bcrypt.compare(password, user.password_hash);

      if (!ok) {
        return res.status(401).json({ error: "Credenciales inválidas" });
      }
      if (!process.env.JWT_SECRET) {
        return res.status(500).json({ error: "Falta JWT_SECRET en .env" });
      }

      const token = jwt.sign(
        { id_usuario: user.id_usuario, email: user.email },
        process.env.JWT_SECRET,
        { expiresIn: "7d" }
      );

      return res.json({
        message: "Login exitoso",
        token,
        user: {
          id_usuario: user.id_usuario,
          nombre: user.nombre,
          email: user.email,
        },
      });
    }
  );
});

module.exports = router;
