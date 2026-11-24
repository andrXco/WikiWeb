# tallerWikiWeb

Wiki del proyecto. Incluye la sección **Arquitectura**, que muestra
el PDF del modelo C4 de la plataforma BPMN dentro de la página.

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
| `/arquitectura` | Visor del PDF de arquitectura (modelo C4) |
| `/contacto`     | Formulario de contacto                    |

El PDF está en `src/main/resources/static/docs/arquitectura-bpmn.pdf`. Para actualizarlo, reemplaza ese archivo
y vuelve a construir con `docker compose up -d --build`.

## Documentos de la entrega

Los PDF están en `src/main/resources/static/docs/` y se registran en `DataSeeder`
(método `documentosIniciales`). Para publicar uno nuevo: copia el PDF en esa carpeta,
agrega su `new Documento(...)` en el seeder y vuelve a construir con
`docker compose up -d --build`.