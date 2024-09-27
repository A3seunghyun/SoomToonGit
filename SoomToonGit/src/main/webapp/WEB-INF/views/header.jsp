<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/css/header.css" rel="stylesheet" type="text/css">
<title>header -승현</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/header.js" defer></script>

</head>
<body>
	<div class="header">
		<div class="header-1">
			<div class="header-content">
				<a class="logo_container" id="logo_container" href="${pageContext.request.contextPath}/soomtoon_daily">
					<img src="resources/img/Soomtoon_logo.png" class="logo_img">
				</a>
				<div class="menu-container">
					<a class="menu active" href="${pageContext.request.contextPath}/soomtoon_daily"><p>웹툰</p></a>
					<a class="menu" href="${pageContext.request.contextPath}/freeBulletinBoard"><p>자유게시판</p></a>
					<a class="menu" href="${pageContext.request.contextPath}/soomtoon_daily"><p>홈으로.</p></a>
				</div>
				<div class="search-container">
					<form>
						<div class="input-container">
							<input type="text" name="search" placeholder="제목, 작가를 입력하세요." value="" />
						</div>
						<a>
							<img class="search-img" alt="검색" aria-hidden="true" width="24" height="24" decoding="async" data-nimg="1" class="active:opacity-30 cursor-pointer" style="color:transparent" src="data:image/svg+xml,%3csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M15.1991 6.74703C12.865 4.4131 9.08077 4.4131 6.74668 6.74703C4.41256 9.08098 4.41256 12.8651 6.74668 15.199C8.90131 17.3535 12.2917 17.5192 14.6364 15.696L17.9384 18.9978L18.999 17.9371L15.6969 14.6353C17.5194 12.2908 17.3535 8.90121 15.1991 6.74703ZM7.8073 7.80772C9.55561 6.05953 12.3902 6.05953 14.1385 7.80772C15.8868 9.55588 15.8868 12.3902 14.1385 14.1383C12.3902 15.8865 9.55561 15.8865 7.8073 14.1383C6.05902 12.3902 6.05902 9.55588 7.8073 7.80772Z' fill='%23222222'/%3e %3c/svg%3e">
						</a>
					</form>
				</div>
				<div class="user-menu-container">
					<a id="stage-btn" class="menu-box" style="cursor: pointer; margin: 0px 0px;">
						<img alt="스테이지" aria-hidden="true" width="48" height="24" decoding="async" data-nimg="1" class="active:opacity-30" style="color:transparent" src="data:image/svg+xml,%3csvg width='48' height='24' viewBox='0 0 48 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath d='M44 18H48V2H4V6H0V22H44V18Z' fill='%23FFBC00'/%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M7.69458 7.5C6.69379 7.5 5.88789 7.75396 5.27613 8.26189C4.66513 8.76982 4.35886 9.43811 4.35886 10.2675C4.35886 10.9527 4.55995 11.5028 4.96212 11.9171C5.3643 12.3315 5.9923 12.6238 6.8477 12.7934L8.27232 13.0726C8.99932 13.1992 9.36283 13.4954 9.36283 13.9611C9.36283 14.2573 9.23599 14.4875 8.98386 14.6524C8.73172 14.8174 8.37905 14.9003 7.92583 14.9003C7.35273 14.9003 6.88018 14.7714 6.50817 14.5128C6.13616 14.255 5.91574 13.9059 5.84768 13.4655H4C4.07734 14.4054 4.46637 15.1458 5.16785 15.6867C5.86856 16.2284 6.75334 16.5 7.82297 16.5C8.8663 16.5 9.70467 16.2499 10.3373 15.7504C10.97 15.2517 11.2871 14.5872 11.2871 13.7578C11.2871 13.0642 11.0643 12.5286 10.6196 12.1519C10.1749 11.776 9.51209 11.4982 8.63118 11.321L7.55382 11.1046C7.13463 11.0202 6.82217 10.902 6.61722 10.7494C6.41149 10.5974 6.3094 10.3811 6.3094 10.1026C6.3094 9.77263 6.4463 9.51177 6.71931 9.32148C6.9931 9.1312 7.36124 9.03606 7.82297 9.03606C8.80674 9.03606 9.36205 9.46803 9.49044 10.3304H11.325C11.2739 9.79795 11.1262 9.33836 10.8826 8.9532C10.639 8.5688 10.335 8.27417 9.9715 8.07084C9.608 7.86829 9.23831 7.72251 8.86243 7.6335C8.48578 7.5445 8.09675 7.5 7.69458 7.5ZM19.3947 9.36598V7.69028H11.7101V9.36598H14.622V16.322H16.4821V9.36598H19.3947ZM24.7568 14.6593L25.4374 16.322H27.3995L23.6531 7.63964H21.9099L18.1511 16.322H20.1264L20.807 14.6593H24.7568ZM24.0762 12.9959H21.4853L22.7683 9.83555L24.077 12.9967L24.0762 12.9959ZM36.0973 11.5113H31.5172V13.1356H34.0957C33.8993 13.635 33.5953 14.0286 33.1854 14.3164C32.7747 14.6041 32.2743 14.7476 31.685 14.7476C30.8721 14.7476 30.2178 14.4921 29.7213 13.9803C29.2255 13.4678 28.9773 12.844 28.9773 12.1082C28.9773 11.2358 29.2341 10.543 29.7468 10.0258C30.2604 9.51023 30.927 9.25166 31.7484 9.25166C32.9116 9.25166 33.6688 9.73811 34.0191 10.7118H35.9944C35.7547 9.68747 35.238 8.89872 34.4422 8.34476C33.6471 7.79003 32.7407 7.51304 31.7229 7.51304C30.4143 7.51304 29.3176 7.94425 28.432 8.80742C27.5472 9.67059 27.1041 10.7747 27.1041 12.1205C27.1041 13.3304 27.5364 14.3632 28.4003 15.2171C29.2642 16.0719 30.3547 16.4992 31.6718 16.4992C32.9456 16.4992 33.9124 16.0427 34.5706 15.1281L34.6734 16.322H36.0973V11.5113ZM39.3943 9.35371H44V7.69028H37.5343V16.322H44V14.6586H39.3943V12.8939H43.4733V11.2312H39.3943V9.35371Z' fill='%23222222'/%3e %3c/svg%3e">
					</a>
					<button id="storage-btn" class="menu-box">
						<img alt="보관함" aria-hidden="true" width="24" height="24" decoding="async" data-nimg="1" class="active:opacity-30" style="color:transparent" src="data:image/svg+xml,%3csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M20 2H4V3.5H20V2ZM3 6C2.44772 6 2 6.44772 2 7V19C2 20.6569 3.34315 22 5 22H19C20.6569 22 22 20.6569 22 19V7C22 6.44772 21.5523 6 21 6H3ZM20.5 7.5H3.5V19C3.5 19.8284 4.17157 20.5 5 20.5H19C19.8284 20.5 20.5 19.8284 20.5 19V7.5ZM9 11H15V12.5H9V11Z' fill='%23222222'/%3e %3c/svg%3e">
					</button>
					<a id="gift-btn" class="menu-box">
						<img alt="선물" aria-hidden="true" width="24" height="24" decoding="async" data-nimg="1" class="active:opacity-30" style="color:transparent" src="data:image/svg+xml,%3csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M11.9992 5.99905L9 2.99981C7.89543 1.89524 6.10457 1.89524 5 2.99981C4.18885 3.81096 3.97337 4.99222 4.35357 6H4C2.89543 6 2 6.89543 2 8V20C2 21.1046 2.89543 22 4 22H11.25H12.75H20C21.1046 22 22 21.1046 22 20V8C22 6.89543 21.1046 6 20 6H19.6449C20.0251 4.99222 19.8096 3.81096 18.9985 2.99981C17.8939 1.89524 16.103 1.89524 14.9985 2.99981L11.9992 5.99905ZM17.9993 6C18.5517 5.44751 18.5516 4.55172 17.9989 3.99943C17.4463 3.44734 16.5509 3.44762 15.9987 4.00007L14 5.99981L17.9993 6ZM9.99981 6L8 3.99981C7.44771 3.44753 6.55228 3.44753 6 3.99981C5.44771 4.5521 5.44771 5.44753 6 5.99981L9.99981 6ZM20 20.5H12.75V7.5H20C20.2761 7.5 20.5 7.72386 20.5 8V20C20.5 20.2761 20.2761 20.5 20 20.5ZM11.25 20.5V7.5H4C3.72386 7.5 3.5 7.72386 3.5 8V20C3.5 20.2761 3.72386 20.5 4 20.5H11.25Z' fill='%23222222'/%3e %3c/svg%3e">
					</a>
					<button id="logoin-btn" class="menu-box">
						<img alt="내 정보" aria-hidden="true" width="24" height="24" decoding="async" data-nimg="1" class="active:opacity-30" style="color:transparent" src="data:image/svg+xml,%3csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M12.0009 2C9.23899 2 7 4.23898 7 7.00091C7 9.76285 9.23899 12.0018 12.0009 12.0018C14.7629 12.0018 17.0018 9.76285 17.0018 7.00091C17.0018 4.23898 14.7629 2 12.0009 2ZM8.5 7.00091C8.5 5.06741 10.0674 3.5 12.0009 3.5C13.9344 3.5 15.5018 5.06741 15.5018 7.00091C15.5018 8.93441 13.9344 10.5018 12.0009 10.5018C10.0674 10.5018 8.5 8.93441 8.5 7.00091Z' fill='%23222222'/%3e %3cpath d='M8.75 14C5.02208 14 2 17.0221 2 20.75V21.9953H3.5V20.75C3.5 17.8505 5.85051 15.5 8.75 15.5H15.2527C18.1522 15.5 20.5027 17.8505 20.5027 20.75V21.9953H22.0027V20.75C22.0027 17.0221 18.9807 14 15.2527 14H8.75Z' fill='%23222222'/%3e %3c/svg%3e">
					</button>
					<button id="user-info-btn" class="menu-box" style="display: flex;">
						<div class="profile-img">
							<img alt="프로필" class="jsx-1724293461 absolute top-0 left-0 h-full w-full select-none object-cover visible" src="https://k.kakaocdn.net/dn/czbsDB/btsISTRQ6XX/wkM6xFmtKraCIPydsZiWt1/img_640x640.jpg">
						</div>
						<img class="down-arrow"alt="아래 화살표" aria-hidden="true" width="12" height="12" decoding="async" data-nimg="1" class="active:opacity-30 ml-4pxr h-12pxr w-12pxr" style="color:transparent" src="data:image/svg+xml,%3csvg width='12' height='12' viewBox='0 0 12 12' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M3.04482 3.5L6 6.42893L8.95518 3.5L10 4.53553L6 8.5L2 4.53553L3.04482 3.5Z' fill='%23222222'/%3e %3c/svg%3e">
					</button>
				</div>
			</div>
			<div class="info-menu" id="info-menu">
				<a>
					<div class="user-name">
						<span class="name-text">최승현</span>
						<span class="name-text">님</span>
						<img alt="다음" aria-hidden="true" width="12" height="12" decoding="async" data-nimg="1" class="pointer-events-none" src="data:image/svg+xml,%3csvg width='12' height='12' viewBox='0 0 12 12' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath d='M5.06792 10.9978L9.99857 5.99888L5.06792 1L4 2.05335L7.89168 5.99888L4 9.94442L5.06792 10.9978Z' fill='%23999999'/%3e %3c/svg%3e" style="color: transparent;">
					</div>				
				</a>
				<div class="info-menu-box">
					<div class="info-menu-content">
						<div class="info-menu-item">
							<a>
								<div class="items">
									<div>
										<img alt="아이콘" aria-hidden="true" width="24" height="24" decoding="async" data-nimg="1" class="pointer-events-none" src="data:image/svg+xml,%3csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M12.0001 1C7.30567 1 3.50009 4.80558 3.50009 9.5V15L1.95634 17.47C1.54006 18.136 2.0189 19 2.80433 19H21.1959C21.9814 19 22.4602 18.136 22.0439 17.47L20.5001 15V9.5C20.5001 4.80558 16.6945 1 12.0001 1ZM12 2.5C8.13405 2.5 5.00004 5.63401 5.00004 9.5V15L3.50004 17.5H20.5L19 15V9.5C19 5.63401 15.866 2.5 12 2.5Z' fill='%23222222'/%3e %3cpath d='M12.0001 23.5C9.76133 23.5 7.86618 22.0286 7.22905 20H8.83696C9.39869 21.1825 10.6039 22 12.0001 22C13.3963 22 14.6016 21.1825 15.1633 20H16.7712C16.1341 22.0286 14.239 23.5 12.0001 23.5Z' fill='%23222222'/%3e %3c/svg%3e" style="color: transparent;">
									</div>
									<div>
										<span>알림</span>
									</div>
								</div>
							</a>
						</div>
						<div class="info-menu-item">
							<a>
								<div class="items">
									<div>
										<img alt="아이콘" aria-hidden="true" width="24" height="24" decoding="async" data-nimg="1" class="pointer-events-none" src="data:image/svg+xml,%3csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath d='M17 9.5H7V8H17V9.5Z' fill='%23222222'/%3e %3cpath d='M13 13.25H7V11.75H13V13.25Z' fill='%23222222'/%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M12 20.1717C18.0752 20.1717 23 15.88 23 10.5859C23 5.29173 18.0752 1 12 1C5.92488 1 1 5.29173 1 10.5859C1 13.5626 2.55699 16.2224 5 17.9806V21.9989C5 22.7656 5.82713 23.2471 6.49377 22.8685L11.2789 20.1514C11.5173 20.1649 11.7577 20.1717 12 20.1717ZM6.5 17.2121L5.87621 16.7631C3.76582 15.2443 2.5 13.0116 2.5 10.5859C2.5 6.30736 6.55281 2.5 12 2.5C17.4472 2.5 21.5 6.30736 21.5 10.5859C21.5 14.8644 17.4472 18.6717 12 18.6717C11.7859 18.6717 11.5736 18.6657 11.3634 18.6538L10.9224 18.629L6.5 21.14V17.2121Z' fill='%23222222'/%3e %3c/svg%3e" style="color: transparent;">
									</div>
									<div>
										<span>댓글 내역</span>
									</div>
								</div>
							</a>
						</div>
						<div class="info-menu-item">
							<a>
								<div class="items">
									<div>
										<img alt="아이콘" aria-hidden="true" width="24" height="24" decoding="async" data-nimg="1" class="pointer-events-none" src="data:image/svg+xml,%3csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M12.7857 18.0742L20.4506 20.2642C21.7282 20.6292 23 19.6699 23 18.3412V4.00122C23 2.67246 21.7282 1.71313 20.4506 2.07817L6.50027 6.06396H3C1.89543 6.06396 1 6.95939 1 8.06396V14.2783C1 15.3828 1.89543 16.2783 3 16.2783H6.5V19.8541C6.5 21.5898 7.9071 22.9969 9.64286 22.9969C11.3786 22.9969 12.7857 21.5898 12.7857 19.8541V18.0742ZM9.61937 15.6096L8 15.1469V7.1955L20.8626 3.52046C21.182 3.4292 21.5 3.66903 21.5 4.00122V18.3412C21.5 18.6733 21.182 18.9132 20.8626 18.8219L12.7857 16.5142V16.5099L9.61937 15.6096ZM9.20856 17.0522L11.2857 17.6457V19.8541C11.2857 20.7614 10.5502 21.4969 9.64286 21.4969C8.73553 21.4969 8 20.7614 8 19.8541V16.7085L9.20856 17.0522ZM6.5 14.7783V7.56396H3C2.72386 7.56396 2.5 7.78782 2.5 8.06396V14.2783C2.5 14.5544 2.72386 14.7783 3 14.7783H6.5Z' fill='%23222222'/%3e %3c/svg%3e" style="color: transparent;">
									</div>
									<div>
										<span>공지사항</span>
									</div>
								</div>
							</a>
						</div>
					</div>
				</div>
				<div class="logout-btn">
					<span>로그아웃</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>