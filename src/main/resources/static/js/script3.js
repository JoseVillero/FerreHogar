    document.getElementById("downloadBtn").addEventListener("click", function () {
        const contenido = document.getElementById('ticketFactura');
        const opciones = {
            margin: 10,
            filename: 'factura.pdf',
            image: { type: 'jpeg', quality: 0.98 },
            html2canvas: { scale: 2 },
            jsPDF: { unit: 'mm', format: 'a4', orientation: 'portrait' }
        };

        // Generar el PDF utilizando html2pdf
        html2pdf().from(contenido).set(opciones).outputPdf();
    });

