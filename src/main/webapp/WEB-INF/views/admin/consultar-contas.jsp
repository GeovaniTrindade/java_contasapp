<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ContasApp</title>
<!-- Folhas de estilo CSS -->
<link rel="stylesheet" href="../resources/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet" href="../resources/css/jquery.dataTables.min.css"
	type="text/css" />
<!-- estilo CSS para as mensagens de erro de validação -->
<style>
label.error {
	color: #d9534f;
} /* cor do texto da mensagem de erro */
input.error {
	border: 2px solid #d9534f;
} /* cor (erro) nos campos input text */
</style>
</head>
<body>
	<!-- componente navbar -->
	<jsp:include page="/WEB-INF/views/admin/components/navbar.jsp"></jsp:include>

	<!-- componente messages -->
	<jsp:include page="/WEB-INF/views/admin/components/messages.jsp"></jsp:include>

	<div class="container mt-4">
		<div class="card">
			<div class="card-body">
				<h4>Consulta de contas</h4>
				<p>Pesquise as suas contas dentro de um período de datas.</p>
				<hr />

				<form id="formConsulta" action="consultar-contas-post" method="post">

					<div class="row mb-2">
						<div class="col-md-3">
							<input type="date" id="dataInicio" name="dataInicio"
								class="form-control" value="${dt_inicio}" />
						</div>
						<div class="col-md-3">
							<input type="date" id="dataFim" name="dataFim"
								class="form-control" value="${dt_fim}" />
						</div>
						<div class="col-md-6">
							<input type="submit" value="Pesquisar Contas"
								class="btn btn-success" />
						</div>
					</div>

				</form>

				<c:if test="${not empty listagem_contas}">

					<div class="mt-3 table-responsive">
						<table id="tabela" class="table table-sm">
							<thead>
								<tr>
									<th>Data</th>
									<th>Valor</th>
									<th>Tipo</th>
									<th>Nome da conta</th>
									<th>Operações</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${listagem_contas}" var="conta">

									<tr>
										<td><fmt:formatDate value="${conta.data}"
												pattern="EEE, dd/MM/yyyy" /></td>
										<td><fmt:formatNumber value="${conta.valor}"
												type="currency" currencySymbol="R$" /></td>
										<td><c:if test="${conta.tipo == 1}">
												<span class="badge bg-success">RECEBER</span>
											</c:if> <c:if test="${conta.tipo == 2}">
												<span class="badge bg-danger">PAGAR</span>
											</c:if></td>
										<td>${conta.nome}</td>
										<td><a
											href="/java_contasapp/admin/editar-contas?id=${conta.id}"
											class="btn btn-sm btn-outline-primary"> Editar </a> <a
											href="/java_contasapp/admin/excluir-contas?id=${conta.id}"
											onclick="return confirm('Deseja excluir esta conta?');"
											class="btn btn-sm btn-outline-danger"> Excluir </a></td>
									</tr>

								</c:forEach>

							</tbody>
						</table>
					</div>

				</c:if>

			</div>
		</div>
	</div>
	<!-- Arquivos JavaScript -->
	<script src="../resources/js/bootstrap.bundle.min.js"></script>
	<script src="../resources/js/jquery-3.7.0.min.js"></script>
	<script src="../resources/js/jquery.validate.min.js"></script>
	<script src="../resources/js/additional-methods.min.js"></script>
	<script src="../resources/js/messages_pt_BR.min.js"></script>
	<script src="../resources/js/jquery.dataTables.min.js"></script>
	<script>
		$(document).ready(function() {

			$("#formConsulta").validate({
				rules : {
					"dataInicio" : {
						required : true
					},
					"dataFim" : {
						required : true
					}
				}
			});

			$("#tabela").DataTable({
				language : {
					url : '../resources/js/dataTables.pt-BR.json'
				}
			});

		})
	</script>
</body>
</html>



