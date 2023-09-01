<nav class="navbar navbar-expand-lg navbar-primary bg-primary">
	<div class="container">
		<a class="navbar-brand text-light" href="#">Contas App</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ms-auto">
				<li class="nav-item"><a class="nav-link text-light"
					href="/java_contasapp/admin/dashboard">Dashboard</a></li>
				<li class="nav-item"><a class="nav-link text-light"
					href="/java_contasapp/admin/cadastrar-contas">Cadastrar Contas</a>
				</li>
				<li class="nav-item"><a class="nav-link text-light"
					href="/java_contasapp/admin/consultar-contas">Consultar Contas</a>
				</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle text-light" href="#"
					id="userDropdown" role="button" data-bs-toggle="dropdown"
					aria-expanded="false"> <strong>${usuario_auth.nome}</strong>
				</a>
					<ul class="dropdown-menu" aria-labelledby="userDropdown">
						<li><a class="dropdown-item" href="#">Minha Conta</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="/java_contasapp/logout"
							onclick="return confirm('Deseja realmente sair do sistema?');">
								Sair do Sistema </a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>



