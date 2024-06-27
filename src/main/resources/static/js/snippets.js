const exampleModal = document.getElementById('exampleModal')
if (exampleModal) {
    exampleModal.addEventListener('show.bs.modal', event => {
        // Button that triggered the modal
        const button = event.relatedTarget
        // Extract info from data-bs-* attributes
        const recipient = button.getAttribute('data-bs-whatever')
        // If necessary, you could initiate an Ajax request here
        // and then do the updating in a callback.

        // Update the modal's content.
        const modalTitle = exampleModal.querySelector('.modal-title')
        const modalBodyInput = exampleModal.querySelector('.modal-body input')

        modalTitle.textContent = `New message to ${recipient}`
        modalBodyInput.value = recipient
    })
}


document.addEventListener("DOMContentLoaded", function() {
    document.querySelectorAll(".copiar-btn").forEach(function(btn) {
        btn.addEventListener("click", function() {
            var linkId = this.getAttribute("data-link-id");
            var input = document.getElementById("texto-" + linkId);
            navigator.clipboard.writeText(input.value).then(function() {
                console.log('Copiado com sucesso!');
            }).catch(function(err) {
                console.error('Erro ao copiar: ', err);
            });
        });
    });
});