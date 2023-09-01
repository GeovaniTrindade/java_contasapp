<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Autenticação de Usuários</title>
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
				<h2 class="text-center">Acesso ao Sistema</h2>
				<p class="text-center">Entre com as suas credenciais de acesso.</p>
				<h4 class="text-danger text-center">${mensagem_erro}</h4>
				<form id="formLogin" action="login-post" method="post">
					<div class="mb-2">
						<label for="email" class="form-label">Email de acesso:</label> <input
							type="email" class="form-control" id="email" name="email"
							placeholder="Digite seu email">
					</div>
					<div class="mb-2">
						<label for="senha" class="form-label">Senha de acesso:</label> <input
							type="password" class="form-control" id="senha" name="senha"
							placeholder="Digite sua senha">
					</div>
					<div class="mb-3 text-end">
						<a href="/java_contasapp/recuperar-senha"> Esqueci minha
							senha! </a>
					</div>
					<div class="d-grid">
						<button type="submit" class="btn btn-primary">Entrar</button>
					</div>
					<div class="d-grid mt-2">
						<a href="/java_contasapp/criar-usuario" class="btn btn-light">Não
							possui conta? Cadastre-se aqui!</a>
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
							$("#formLogin")
									.validate(
											{
												rules : {
													"email" : {
														required : true,
														email : true
													},
													"senha" : {
														required : true,
														pattern : /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/
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



