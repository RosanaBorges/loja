$(document).ready(function() {
    $('#btn-cadastrar').submit(function(event) {
        event.preventDefault();

        var funcionario = {
            nome: $('#nome').val(),
            email: $('#email').val(),
            cpf: $('#cpf').val(),
            rg: $('#rg').val(),
            telefone: $('#telefone').val(),
            atividade: $('#atividade').val(),
            loja: $('#loja').val(),
            senha: $('#senha').val(),
            senhaConfirmacao: $('#senhaConfirmacao').val()
        };
        console.log(funcionario);

        $.ajax({
            url: 'api/v1/funcionario/salvar',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(funcionario),
            success: function(response) {
                alert('Funcionário cadastrado com sucesso!');
                $('#formCadastro')[0].reset();
            },
            error: function(xhr, status, error) {
                var errorMessage = 'Erro ao cadastrar funcionário: ';
                if (xhr.responseJSON && xhr.responseJSON.message) {
                    errorMessage += xhr.responseJSON.message;
                } else {
                    errorMessage += xhr.responseText;
                }
                alert(errorMessage);
            }
        });
    });
});