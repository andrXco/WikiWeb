# tallerWikiWeb

Wiki del proyecto. Incluye la sección Documentos con los documentos de la entrega final en PDF.
Requisito: Docker Desktop encendido.

**Cualquier sistema (terminal):**

```bash
docker compose up -d --build
```

Luego abre `http://localhost:8080`.

Para detenerla: `docker compose down`.

## Rutas

| Ruta            | Qué muestra                               |
| --------------- | ----------------------------------------- |
| `/`             | Inicio                                    |
| `/wiki`         | Secciones de la wiki                      |
| `/documentos`   | Documentos de la entrega final (visor PDF)|
| `/contacto`     | Formulario de contacto                    |

## Documentos de la entrega

Los PDF están en `src/main/resources/static/docs/` y se registran en `DataSeeder`
(método `documentosIniciales`). Para publicar uno nuevo: copia el PDF en esa carpeta,
agrega su `new Documento(...)` en el seeder y vuelve a construir con
`docker compose up -d --build`.