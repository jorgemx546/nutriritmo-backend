# Flujo Git – Equipo NutriRitmo

## Ramas principales

- `main` → rama estable para entrega.
- `develop` → rama de integración del equipo.
- `feature/<nombre>/<tarea>` → rama individual para cada integrante.
  - Ejemplos:
    - `feature/jared/login-ui`
    - `feature/daniel/backend-ayunos`
    - `feature/erick/progreso-android`
- `hotfix/<descripcion>` → correcciones urgentes sobre `main`.

---

## Flujo de trabajo para cada integrante

### 1. Clonar repositorio

```bash
git clone <URL_DEL_REPO>
cd <carpeta-del-proyecto>

2. Cambiarse a develop y actualizar
git checkout develop
git pull origin develop

3. Crear su propia rama feature
git checkout -b feature/<nombre>/<tarea>

4. Trabajar y subir sus cambios
git add .
git commit -m "feat: descripcion corta"
git push -u origin feature/<nombre>/<tarea>

5. Crear un Pull Request

Desde feature/<nombre>/<tarea>

Hacia develop

6. Revisión del líder

El líder revisa el PR

Puede pedir cambios

Si todo está correcto → se aprueba

Publicar versión estable (solo el líder)
git checkout main
git pull origin main
git merge develop
git push origin main

Reglas del equipo

❌ Nadie hace push directo a main.

✔ Todo pasa por Pull Request.

✔ Cada rama feature debe tener un nombre claro.

✔ Los commits usan formato:

feat: ...

fix: ...

refactor: ...

docs: ...


---

# Reglas del Proyecto – NutriRitmo

## 1. Arquitectura obligatoria

- Android desarrollado en **Kotlin**
- Uso de **Retrofit** para consumir la API
- API construida con **Node.js + Express**
- Base de datos en **MySQL** (Workbench)
- Tablas mínimas:
  - `usuarios`
  - `ayunos`
  - `frases_motivacionales`

⚠ La app Android **NO** se conecta directo a MySQL.  
Siempre pasa por la API REST.

---

## 2. Tecnologías NO permitidas

- Firebase (como BD principal)
- SQLite (como BD principal)
- PHP, Laravel, Django, Rails, Spring
- MongoDB y otras BD no acordadas

---

## 3. Reglas del flujo Git

- Ramas permitidas:
  - `main`  
  - `develop`  
  - `feature/<nombre>/<tarea>`  
  - `hotfix/<descripcion>`  
- Nadie hace push a `main`
- Todos los cambios pasan por Pull Request
- Los PR deben tener descripción clara y funcionar correctamente

---

## 4. Formato de commits

- `feat: descripcion` (nueva función)
- `fix: descripcion` (corrección)
- `refactor: descripcion` (mejora de código)
- `docs: descripcion` (solo documentación)

---

## 5. Estándares de API

Todos los endpoints deben comenzar con:

/api

css
Copiar código

Las respuestas deben ser JSON del tipo:

```json
{
  "ok": true,
  "message": "Mensaje descriptivo",
  "data": { }
}
Códigos de error:

400 → error del cliente

404 → no encontrado

500 → error interno
