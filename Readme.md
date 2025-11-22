# nutriritmo-backend
Backend API for NutriRitmo – Node.js + Express + MySQL.

---

## 🧱 Arquitectura General
Android (Kotlin)
↕ Retrofit
Backend (Node.js + Express)
↕ MySQL Workbench

yaml
Copiar código

---

## 📌 Funcionalidades principales
- Registro y Login de usuarios  
- Gestión de ayunos  
- Historial  
- Frases motivacionales  
- Consumo desde Android por Retrofit  

---

## 🛠 Tecnologías utilizadas
- Node.js
- Express.js
- MySQL (Workbench)
- dotenv
- CORS

---

## 👥 Equipo de desarrollo
| Integrante | Rol |
|-----------|------|
| Daniel | Backend / API REST |
| Jared | Android – UI / UX |
| Víctor | Android – Retrofit / Lógica |
| Erick | DBA – MySQL Workbench |
| Jorge | Líder / Arquitectura / GitHub |

---

## 🌿 Ramas del repositorio
- **main** → rama estable (solo el líder puede hacer merge)
- **develop** → integración del equipo
- **feature/*** → ramas individuales

Ejemplo:
feature/daniel/backend-ayunos

yaml
Copiar código

---

## 🔄 Flujo de trabajo Git
1. Cambiar a `develop`
git checkout develop
git pull origin develop

markdown
Copiar código
2. Crear rama feature
git checkout -b feature/<nombre>/<tarea>

markdown
Copiar código
3. Subir cambios
git add .
git commit -m "feat: descripción"
git push -u origin feature/<nombre>/<tarea>

yaml
Copiar código
4. Crear Pull Request → develop  
5. Aprobación del líder  
6. Merge a main (solo el líder)

---

## 📦 Instalación (opcional si el profe lo pide)
npm install
npm run dev

yaml
Copiar código

---

## 📁 Estructura prevista
nutriritmo-backend/
├── docs/
├── src/
├── config/
├── package.json
└── README.md

yaml
Copiar código

---

## 📬 Contacto del equipo
Proyecto académico – Universidad Tecnológica.  
Cualquier duda técnica → contactar al líder del equipo por favor.
