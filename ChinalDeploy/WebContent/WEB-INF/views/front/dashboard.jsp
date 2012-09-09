<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head id="M_Head1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/front/dashboard/style.css" />">

<meta charset="UTF-8">
<meta name="DESCRIPTION" content="钱隆投资借贷平台系统">

<meta http-equiv="CACHE-CONTROL" content="NO-CACHE">
<meta http-equiv="PRAGMA" content="NO-CACHE">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/front/dashboard/home.css" />">

<title>钱隆投资借贷平台系统</title>
</head>
<body class="full-template ">
	<div class="main">
		<div align="center">
			<div class="sitewrapper2011">
				<noscript>&lt;div style="color: #F00; background-color:
					#FFF; width: 960px; padding: 20px; display: block;"&gt;Your browser
					is not enabled to use JavaScript. Please enable JavaScript to
					invest or borrow on Prosper.com.&lt;/div&gt;</noscript>
				<div class="header">
					<div class="header-main">
						<div class="logo">
							<img src="<c:url value="/resources/front/dashboard/nav-logo.png" />" width="293" height="108" alt="钱隆投资借贷平台系统" class="logo-img">
						</div>

						<div class="member-area">
							<span id="M_c5_c4_lblNotAuthenticated"><a
								id="M_c5_c4_hlSignIn" class="first"
								href="<c:url value="/management/system/maintain" />">登陆</a><a
								id="M_c5_c4_hlRegister"
								href="<c:url value="/management/system/maintain" />">注册</a>
								<a href="<c:url value="/management/system/maintain" />">帮助</a> </span>
						</div>

						<div id="M_c5_NAME_MAIN_MENU" class="header-primary">
							<ul id="M_c5_TOP_MENU_LEND" class="level1 menu-invest">
								<li class="submenu"><a
									href="<c:url value="/management/system/maintain" />">投资</a>
									<ul class="level2">
										<li class="quick-invest"><a
											href="<c:url value="/management/system/maintain" />">Quick Invest</a></li>
										<li class="browse-notes"><a
											href="<c:url value="/management/system/maintain" />">Browse Listings</a></li>
									</ul></li>
							</ul>

							<ul id="M_c5_TOP_MENU_BORROW" class="level1 menu-borrow">
								<li class="submenu"><a href="<c:url value="/management/system/maintain" />">借贷</a>
									<ul class="level2">
										<li id="M_c5_Li1" class="loan-types"><a
											href="<c:url value="/management/system/maintain" />/">Loan Types</a></li>
										<li id="M_c5_Li2" class="how-to-get-a-loan"><a
											href="<c:url value="/management/system/maintain" />">How to Get a Loan</a></li>
										<li id="M_c5_Li3" class="rates-and-fees last"><a
											href="<c:url value="/management/system/maintain" />">Loan Rates and Fees</a></li>
									</ul></li>
							</ul>


							<ul id="M_c5_TOP_MENU_HOW_WORKS" class="menu-how-it-works">
								<li><a
									href="<c:url value="/management/system/maintain" />">操作流程</a></li>
							</ul>

							<ul id="M_c5_TOP_MENU_ABOUT_US" class="level1 menu-about-us">
								<li class="submenu"><a href="">关于钱隆</a>

									<ul class="level2">
										<li class="management"><a
											href="">简介</a></li>
										<li class="contact-us"><a
											href="">联系我们</a></li>
										<li class="partners"><a
											href="">合作伙伴</a></li>
									</ul></li>
							</ul>
						</div>
					</div>

					<div class="header-secondary">
						<div id="M_c5_NAME_HOME_SUB_MENU"
							class="blank-menu homepage-section" style="display: block;">
							<div class="members">
								<strong>${userCount }</strong> 注册用户
							</div>
							<div class="loans">
								<strong>${companyCount }</strong> 入驻商家
							</div>
						</div>
					</div>
				</div>
				<div class="content-area">
					<form name="aspnetForm" method="post"
						action=""
						id="aspnetForm">
						<div></div>

						<!-- Prosper Overview Page: Success -->
						<div class="top_area" style="height: 123px;">
							<div id="specialPromotion2">
								<div class="headline">
									<h1 class="specialHomepageHeading">
										钱隆是帮助用户发现<span class="gradient">­</span><strong>投资理财渠道</strong><br>
										为用户协调解决<span class="gradient">­</span><strong>资金短缺</strong>的综合化借贷平台系统
									</h1>
									<div class="learn-more" style="margin-left: 5px;">
										<a href="<c:url value="/management/system/maintain" />">了解更多</a>
									</div>
								</div>
								<div
									style="position: absolute; left: 638px; top: 4px; z-index: 2;">
									<a href=""
										title=" Prosper Premier. 1% Cash Back." onclick=""> <img
										src="<c:url value="/resources/front/dashboard/prosper_premier_2012-08-17_homepge.png" />"
										alt=""></a>
								</div>
							</div>

						</div>


						<div class="content-area-padding">
							<div class="info_area">
								<div class="info_box invest_box">
									<div class="headline">
										<h2>我 要 投 资</h2>
									</div>
									<div id="investRateCallout">
										<div class="investCalloutRate">10.02</div>
										<div class="investCalloutPercentSymbol">%</div>
									</div>
									<div class="box_padding">
										<ul class="sell_bullets">
											<li>赚取超额回报</li>

											<li>投资渠道多样化</li>

											<li>掌控投资</li>
										</ul>

										<div class="chart" style="height: 163px;">
											<img
												src="<c:url value="/resources/front/dashboard/invest-returns-chart_10-02.png" />">
										</div>

										<div style="float: left; margin-top: 7px;">
											<a
												href="">
												Open an Account </a>
										</div>
										<div style="float: right;">
											<!--<a href="/invest/">-->
											<a href="" class="button2012">开始投资</a>
										</div>

										<div class="clear"></div>
									</div>

								</div>
								<div class="info_box borrow_box">
									<div class="headline">

										<h2>我 要 借 贷</h2>
									</div>
									<div id="borrowRatesCallout">
										<div style="height: 53px;">
											<div class="borrowCalloutRate">6.59</div>
											<div class="borrowCalloutPercentSymbol">%</div>
										</div>
										<div class="bannerDetail">FOR AA LOANS**</div>
									</div>
									<div class="box_padding">
										<ul class="sell_bullets">
											<li>无担保贷款</li>

											<li>轻松分期还款</li>

											<li>合理利率<br> 6.59% to 35.84% APR
											</li>
										</ul>
										<div class="borrowerFunnelFormHome">
											<div class="form_heading form_row">Check your loan rate</div>

											<div class="borrowerFunnelForm">
												<style type="text/css">
div.borrowerFunnelForm input.uniformField,div.borrowerFunnelForm select.uniformField,div.borrowerFunnelForm select.paddedSelect
	{
	padding: 4px;
	font-size: 13px;
	color: #555;
	border: 1px solid #BBB;
}

div.borrowerFunnelForm input.uniformField {
	padding-left: 22px;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
}

div.borrowerFunnelForm input.uniformField.blur {
	color: #999
}

.borrow_box .form_heading {
	padding-bottom: 11px;
}
</style>
												<div class="form_row">

													<select
														name="M$MainContent$BorrowerFunnel1$ddlListingCategories"
														id="M_MainContent_BorrowerFunnel1_ddlListingCategories"
														class="uniformField">
														<option value="-1">- Select Loan Purpose -</option>
														<option value="1">Debt consolidation</option>
														<option value="2">Home improvement</option>
														<option value="3">Business</option>
														<option value="6">Auto</option>
														<option value="16">Motorcycle</option>
														<option value="17">RV</option>
														<option value="9">Boat</option>
														<option value="15">Medical/Dental</option>
														<option value="19">Vacation</option>
														<option value="13">Household Expenses</option>
														<option value="8">Baby &amp; Adoption Loans</option>
														<option value="11">Engagement Ring Financing</option>
														<option value="20">Wedding Loans</option>
														<option value="10">Cosmetic Procedures</option>
														<option value="14">Large Purchases</option>
														<option value="18">Taxes</option>
														<option value="12">Green Loans</option>
														<option value="7">Other</option>

													</select>
												</div>
												<div class="form_row">
													<input id="M_MainContent_BorrowerFunnel1_txtAmount"
														class="uniformField money"
														placeholder="Enter amount ($2,000 to $25,000)"
														name="M$MainContent$BorrowerFunnel1$txtAmount"
														type="number">
												</div>
												<div class="form_row last_row">
													<select
														name="M$MainContent$BorrowerFunnel1$ddlSelfReportedCreditQuality"
														id="M_MainContent_BorrowerFunnel1_ddlSelfReportedCreditQuality"
														class="uniformField">
														<option value="-1">- Select Your Credit Quality -</option>
														<option value="1">Excellent Credit (760+)</option>
														<option value="2">Good Credit (700+)</option>
														<option value="3">Fair Credit (640+)</option>
														<option value="4">Poor Credit</option>

													</select>
												</div>

												<div class="buttons">
													<a id="M_MainContent_BorrowerFunnel1_btnGoBorrow"
														class="button2012"
														href="<c:url value="/management/system/maintain" />"
														style="display: block">借贷</a>
												</div>
											</div>
											<div class="learn_more" style="float: left;">
												<a href="<c:url value="/management/system/maintain" />">Learn about Loans</a>
											</div>
										</div>

									</div>
								</div>
							</div>

							<div class="clear"></div>

							<div class="promos">
								<div class="promo left_promo">
									<div class="promo_logo">
										<img
											src="<c:url value="/resources/front/dashboard/promo-icon-quote.png" />">
									</div>
									<div class="promo_padding">
										<div class="quote" id="quote_2" style="display: block;">
											"...solidarity, simplicity and cost savings..."

											<div class="quote_logo">
												<img
													src="<c:url value="/resources/front/dashboard/logo-nyt.png" />"
													width="129" height="20" alt="The New York Times">
											</div>
										</div>

										<div class="quote" id="quote_3" style="display: block;">
											"...banks have become tightfisted, but creditworthy borrowers
											haven't gone away."

											<div class="quote_logo">
												<img
													src="<c:url value="/resources/front/dashboard/logo-barrons.png" />"
													width="105" height="22" alt="Barron&#39;s">
											</div>
										</div>

									</div>
								</div>

								<div class="promo right_promo">
									<div class="promo_logo">
										<img
											src="<c:url value="/resources/front/dashboard/promo-icon-earn-100.png" />">
									</div>
									<div class="promo_padding">
										<p>
											<span><strong>Refer Your Friends to Prosper
													for a Loan:</strong></span><br> Refer a friend and earn $100 for each
											friend getting a personal loan. <a
												href="<c:url value="/management/system/maintain" />">Invite
												friends now</a>
										</p>
									</div>
									<div class="clear"></div>
								</div>
							</div>

							<div class="clear"></div>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	<div id="M_divFooter" class="footer">
		<div align="center">
			<div class="sitewrapper">
				<div class="footer-padding">


					<div class="footer-address">
                        <p>四川省成都市xxxx xxxx  邮箱xxxx xxxx 备案号:川ICP备XXXXXX号</p>
                    </div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>