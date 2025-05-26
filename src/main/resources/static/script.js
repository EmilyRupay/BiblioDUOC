// script.js
const API_URL = "/api/libros"; // Cambia si tu endpoint es diferente

document.addEventListener("DOMContentLoaded", listarLibros);
document.getElementById("form-libro").addEventListener("submit", agregarLibro);

function listarLibros() {
  fetch(API_URL)
    .then(res => res.json())
    .then(libros => {
      const lista = document.getElementById("libros-lista");
      lista.innerHTML = "";
      libros.forEach(libro => {
        const fila = document.createElement("tr");
        fila.innerHTML = `
          <td>${libro.titulo}</td>
          <td>${libro.autor}</td>
        `;
        lista.appendChild(fila);
      });
    });
}

function agregarLibro(e) {
  e.preventDefault();
  const titulo = document.getElementById("titulo").value;
  const autor = document.getElementById("autor").value;

  fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ titulo, autor })
  })
    .then(() => {
      listarLibros();
      document.getElementById("form-libro").reset();
    });
}

const API_PRESTAMOS = "/api/prestamos";
let prestamoEditando = null;

document.getElementById("form-prestamo").addEventListener("submit", guardarPrestamo);
document.addEventListener("DOMContentLoaded", listarPrestamos);

function listarPrestamos() {
  fetch(API_PRESTAMOS)
    .then(res => res.json())
    .then(prestamos => {
      const lista = document.getElementById("prestamos-lista");
      lista.innerHTML = "";
      prestamos.forEach(p => {
        const fila = document.createElement("tr");
        fila.innerHTML = `
          <td>${p.run_solicitante}</td>
          <td>${p.id_libro}</td>
          <td>${p.fecha_solicitud}</td>
          <td>${p.fecha_entrega ?? "—"}</td>
          <td>${p.cantidad_dias}</td>
          <td>${p.multas}</td>
          <td>
            <button class="btn btn-warning btn-sm me-1" onclick="editarPrestamo(${p.id_prestamo})">
              <i class="bi bi-pencil"></i>
            </button>
            <button class="btn btn-danger btn-sm" onclick="eliminarPrestamo(${p.id_prestamo})">
              <i class="bi bi-trash"></i>
            </button>
          </td>
        `;
        lista.appendChild(fila);
      });
    });
}

function guardarPrestamo(e) {
  e.preventDefault();
  const prestamo = {
    run_solicitante: document.getElementById("run").value,
    id_libro: parseInt(document.getElementById("id_libro").value),
    fecha_solicitud: document.getElementById("fecha_solicitud").value,
    fecha_entrega: document.getElementById("fecha_entrega").value || null,
    cantidad_dias: parseInt(document.getElementById("dias").value),
    multas: parseInt(document.getElementById("multas").value)
  };

  const metodo = prestamoEditando ? "PUT" : "POST";
  const url = prestamoEditando ? `${API_PRESTAMOS}/${prestamoEditando}` : API_PRESTAMOS;

  fetch(url, {
    method: metodo,
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(prestamo)
  }).then(() => {
    listarPrestamos();
    document.getElementById("form-prestamo").reset();
    prestamoEditando = null;
  });
}

function eliminarPrestamo(id) {
  if (confirm("¿Eliminar este préstamo?")) {
    fetch(`${API_PRESTAMOS}/${id}`, { method: "DELETE" })
      .then(() => listarPrestamos());
  }
}

function editarPrestamo(id) {
  fetch(`${API_PRESTAMOS}/${id}`)
    .then(res => res.json())
    .then(p => {
      document.getElementById("run").value = p.run_solicitante;
      document.getElementById("id_libro").value = p.id_libro;
      document.getElementById("fecha_solicitud").value = p.fecha_solicitud;
      document.getElementById("fecha_entrega").value = p.fecha_entrega ?? "";
      document.getElementById("dias").value = p.cantidad_dias;
      document.getElementById("multas").value = p.multas;
      prestamoEditando = id;
    });
}

