<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp"></jsp:include>

<body>

	<!-- Pre-loader start -->

	<jsp:include page="pre-loader.jsp"></jsp:include>

	<!-- Pre-loader end -->

	<div id="pcoded" class="pcoded">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">

			<jsp:include page="nav.jsp"></jsp:include>

			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">

					<jsp:include page="navbar.jsp"></jsp:include>

					<div class="pcoded-content">

						<!-- Page-header start -->

						<jsp:include page="header.jsp"></jsp:include>

						<!-- Page-header end -->

						<div class="pcoded-inner-content">
							<!-- Main-body start -->
							<div class="main-body">
								<div class="page-wrapper">
									<!-- Page-body start -->
									<div class="page-body">
										<div class="row">
											<div class="col-sm-12">
												<!-- Basic Form Inputs card start -->
												<div class="card">
													<div class="card-header">
														<h4>Cadastro de Usuário</h4>

													</div>
													<div class="card-block">

														<form
															action="<%=request.getContextPath()%>/ServletUsuarioController"
															method="post" id="formUser">

															<input type="hidden" name="acao" id="acao" value="">

															<div class="form-group row">
																<label class="col-sm-2 col-form-label">Id</label>
																<div class="col-sm-8">
																	<input type="text" class="form-control"
																		readonly="readonly" id="nome" name="id"
																		value="${modelLogin.id }">
																</div>
															</div>

															<div class="form-group row">
																<label class="col-sm-2 col-form-label">Nome</label>
																<div class="col-sm-8">
																	<input type="text" class="form-control" name="nome"
																		id="nome" value="${modelLogin.nome }">
																</div>
															</div>

															<div class="form-group row">
																<label class="col-sm-2 col-form-label">E-mail</label>
																<div class="col-sm-8">
																	<input type="email" class="form-control" name="email"
																		id="email" required="required"
																		value="${modelLogin.email }">
																</div>
															</div>

															<div class="form-group row">
																<label class="col-sm-2 col-form-label">Login</label>
																<div class="col-sm-8">
																	<input type="text" class="form-control" name="login"
																		id="login" autocomplete="off"
																		value="${modelLogin.login }">
																</div>
															</div>

															<div class="form-group row">
																<label class="col-sm-2 col-form-label">Senha</label>
																<div class="col-sm-8">
																	<input type="password" class="form-control"
																		name="senha" id="senha" autocomplete="off"
																		value="${modelLogin.senha }">
																</div>
															</div>

															<button type="button"
																class="btn btn-primary waves-effect waves-light"
																onclick="limparForm();">Novo</button>
															<button class="btn btn-success waves-effect waves-light">Cadastrar</button>
															<button type="button" class="btn btn-info"
																onclick="criaDeleteAjax();">Excluir</button>

														</form>
													</div>
												</div>
											</div>
										</div>


									</div>
									<!-- Page-body end -->
								</div>
								<div id="styleSelector"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Required Jquery -->
	<jsp:include page="scripts.jsp"></jsp:include>

	<script type="text/javascript">
	
	   function criaDeleteAjax() {
		   
		   if(confirm("Deseja realmente excluir os dados ?")) {
			   
			   var urlAction = document.getElementById('formUser').action;
			   var idUser = document.getElementById('id').value;
			   
			   $.ajax({
				   
				   method: "get",
				   url: urlAction,
				   data: "id=" + idUser + '&acao=deletarAjax',
				   success: function(response) {
					   
					   limparForm();
					   alert(response);
				   }
				   
			   }).fail(function(xhr, status, errorThrown){
				   
				   alert('Erro ao deletar usuário por id: ' + xhr.responseText);
			   });
		   }
		   
	   }
	   
		function criarDelete() {
			
			if(confirm('Deseja Realmente excluir os dados')) {
				
				document.getElementById("formUser").method = 'get';
				document.getElementById("acao").value = 'deletar';
				document.getElementById("formUser").submit();
				
			}
			
		}

		function limparForm() {

			var elementos = document.getElementById("formUser").elements;

			for (p = 0; p < elementos.length; p++) {

				elementos[p].value = '';
			}
		}
	</script>
</body>

</html>
