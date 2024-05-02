$(document).ready(function(){
    $("#entrar").click(function(){
        var email = $("#login-email").val();
        var senha = $("#login-senha").val();

        if (email.trim() === '' || senha.trim() === '') {
            alert("Por favor, preencha todos os campos.");
            return;
        }

        var data = JSON.stringify({
            email: email,
            senha: senha

        })

        $.ajax({
            url: "http://localhost:8080/api/v1/autenticacao/login",
            method: "POST",
            contentType: "application/json",
            data: data,
            dataType: "json",
            success: function(response) {
                console.log("Login efetuado com sucesso");
                // Lidar com sucesso
                window.location.href = "/html/paginaInicial.html";
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error(jqXHR.responseText);
                // Lidar com erro
                alert("Erro ao efetuar login. Por favor, verifique suas credenciais.");
            }
        });
    });
});

