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

														<form action="<%= request.getContextPath() %>/ServletUsuarioController" method="post">
															<div class="form-group row">
																<label class="col-sm-2 col-form-label">Id</label>
																<div class="col-sm-8">
																	<input type="text" class="form-control"
																		readonly="readonly" id="nome" name="id">
																</div>
															</div>

															<div class="form-group row">
																<label class="col-sm-2 col-form-label">Nome</label>
																<div class="col-sm-8">
																	<input type="text" class="form-control" name="nome" id="nome">
																</div>
															</div>

															<div class="form-group row">
																<label class="col-sm-2 col-form-label">E-mail</label>
																<div class="col-sm-8">
																	<input type="email" class="form-control" name="email" id="email" required="required">
																</div>
															</div>
															
																<div class="form-group row">
																<label class="col-sm-2 col-form-label">Login</label>
																<div class="col-sm-8">
																	<input type="text" class="form-control" name="login" id="login" autocomplete="off">
																</div>
															</div>

															<div class="form-group row">
																<label class="col-sm-2 col-form-label">Senha</label>
																<div class="col-sm-8">
																	<input type="password" class="form-control"
																		name="senha" id="senha" autocomplete="off">
																</div>
															</div>
                                                           
                                                           <button class="btn btn-primary waves-effect waves-light">Novo</button>
                                                           <button class="btn btn-success waves-effect waves-light">Cadastrar</button>
                                                           <button type="button" class="btn btn-info">Excluir</button>
                                                          
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
	<!-- Warning Section Starts -->
	<!-- Older IE warning message -->
	<!--[if lt IE 10]>
    <div class="ie-warning">
        <h1>Warning!!</h1>
        <p>You are using an outdated version of Internet Explorer, please upgrade <br/>to any of the following web browsers to access this website.</p>
        <div class="iew-container">
            <ul class="iew-download">
                <li>
                    <a href="http://www.google.com/chrome/">
                        <img src="assets/images/browser/chrome.png" alt="Chrome">
                        <div>Chrome</div>
                    </a>
                </li>
                <li>
                    <a href="https://www.mozilla.org/en-US/firefox/new/">
                        <img src="assets/images/browser/firefox.png" alt="Firefox">
                        <div>Firefox</div>
                    </a>
                </li>
                <li>
                    <a href="http://www.opera.com">
                        <img src="assets/images/browser/opera.png" alt="Opera">
                        <div>Opera</div>
                    </a>
                </li>
                <li>
                    <a href="https://www.apple.com/safari/">
                        <img src="assets/images/browser/safari.png" alt="Safari">
                        <div>Safari</div>
                    </a>
                </li>
                <li>
                    <a href="http://windows.microsoft.com/en-us/internet-explorer/download-ie">
                        <img src="assets/images/browser/ie.png" alt="">
                        <div>IE (9 & above)</div>
                    </a>
                </li>
            </ul>
        </div>
        <p>Sorry for the inconvenience!</p>
    </div>
    <![endif]-->
	<!-- Warning Section Ends -->

	<!-- Required Jquery -->
	<jsp:include page="scripts.jsp"></jsp:include>
</body>

</html>
