const exampleModal = document.getElementById('exampleModal')
if (exampleModal) {
    exampleModal.addEventListener('show.bs.modal', event => {

        const button = event.relatedTarget
        const recipient = button.getAttribute('data-bs-whatever')
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


document.addEventListener("DOMContentLoaded", function() {
    document.querySelectorAll("#botao-deletar").forEach(function(btn) {
        btn.addEventListener("click", function() {
            var linkId = this.getAttribute("data-link-id");
            fetch('http://localhost:8080/links/' + linkId, {
                method: 'DELETE',
            }).then(function(response) {
                if (response.ok) {
                    var linkElement = document.getElementById("link-" + linkId);
                    linkElement.parentNode.removeChild(linkElement);
                } else {
                    alert('Erro enquanto o link era deletado');
                }
            }).catch(function(err) {
                console.error('Error occurred while making the request: ', err);
            });
        });
    });
});


document.addEventListener('DOMContentLoaded', function() {
    const inputs = document.querySelectorAll('input[type="text"]');

    inputs.forEach(input => {
        input.addEventListener('blur', function(event) {
            const linkId = this.getAttribute('data-link-id');
            if (linkId) { // Verifica se linkId não é null ou undefined
                const newValue = this.value;

                fetch('/links/' + linkId, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({
                        id: linkId,
                        url: newValue
                    })
                })
                    .then(response => {
                        if (response.ok) {
                            console.log('Link atualizado com sucesso!');
                        } else {
                            console.error('Falha ao atualizar o link.');
                        }
                    })
                    .catch(error => console.error('Erro ao enviar a requisição:', error));
            } else {
                console.error('ID do link é null ou undefined.');
                console.log(linkId)
            }
        });
    });
});

