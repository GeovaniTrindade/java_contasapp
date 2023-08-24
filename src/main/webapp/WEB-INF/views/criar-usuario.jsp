<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Criação de conta de usuário</title>


<!-- Folhas de estilo CSS -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css"
	type="text/css" />






<!-- estilo CSS para as mensagens de erro de validação -->
<style>
label.error {
	color: #d9534f;
}

input.error {
	border: 2px solid #d9534f;
}
</style>


</head>
<body>


	<div class="row mt-5">
		<div class="col-md-4 offset-4">
			<div class="card p-4">

				<h2 class="text-center">Crie sua Conta de Usuário</h2>
				<p class="text-center">Entre com os seus dados.</p>

				<h4 class="text-success text-center">${mensagem_sucesso}</h4>
				<h4 class="text-danger text-center">${mensagem_erro}</h4>

				<form id="formCriarUsuario" method="post" action="/java_contasapp/criar-usuario-post">

					<div class="mb-2">
						<label for="nome" class="form-label"> Nome do usuário:</label> <input
							type="text" class="form-control" id="nome" name="nome"
							placeholder="Digite seu nome">
					</div>

					<div class="mb-2">
						<label for="email" class="form-label"> Email de acesso:</label> <input
							type="email" class="form-control" id="email" name="email"
							placeholder="Digite seu email">
					</div>

					<div class="mb-2">
						<label for="senha" class="form-label"> Senha de acesso:</label> <input
							type="password" class="form-control" id="senha" name="senha"
							placeholder="Digite sua senha">
					</div>

					<div class="mb-2">
						<label for="senhaConfirm" class="form-label"> Confirme sua
							senha:</label> <input type="password" class="form-control"
							id="senhaConfirm" name="senhaConfirm"
							placeholder="Confirme sua senha">
					</div>

					<div class="d-grid">
						<button type="submit" class="btn btn-primary">Criar Conta
						</button>
					</div>



					<div class="d-grid mt-2">
						<a href="/java_contasapp/" class="btn btn-light"> Já possui
							conta? Acesse aqui! </a>
					</div>

				</form>
			</div>
		</div>
	</div>


	<!-- Arquivos JavaScript -->
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/jquery-3.7.0.min.js"></script>
	<script src="resources/js/jquery.validate.min.js"></script>
	<script src="resources/js/additional-methods.min.js"></script>
	<script src="resources/js/messages_pt_BR.min.js"></script>

	<script>
		//quando a página abrir, faça...
		$(document)
				.ready(
						function() {
							//validação do formulário
							$("#formCriarUsuario")
									.validate(
											{
												rules : {
													"nome" : {
														required : true,
														minlength : 8,
														maxlength : 100
													},
													"email" : {
														required : true,
														email : true
													},
													"senha" : {
														required : true,
														pattern : /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/
													},
													"senhaConfirm" : {
														required : true,
														equalTo : "#senha"
													}
												},
												messages : {
													"senha" : {
														pattern : "A senha deve conter pelo menos 8 caracteres, incluindo letras, números e pelo menos um caractere especial (@, $, !, %, *, ?, &)."
													}
												}
											});
						})
	</script>



</body>
</html>
