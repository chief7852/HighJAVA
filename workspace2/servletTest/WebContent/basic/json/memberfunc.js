/**
 * 
 */

 function okpro(vinput) {
      console.log("okpro " + vinput);
      vsp = $(vinput).parents('.form-group').find('.sp');
      
      $(vsp).empty();
      $('<img>', {
         'src' : '../images/check.png',
         'width': '20px',
         'height': '20px'
      }).appendTo(vsp);   
      
      // 올바른 형식이 아닙니다 영역 지우기
      $(vinput).parents('.form-group').find('.msg').html("");
   }
   
   function nopro(vinput, text) {
      console.log("okpro " + vinput + ", " + text);
      $(vinput).parents('.form-group').find('.msg').html(text);
      $(vinput).parents('.form-group').find('.msg').css('color', 'red');
      
      $(vinput).parents('.form-group').find('.sp').empty();
   }


function idcheck() {

	idvalue = $('#id').val().trim();

	if (idvalue.length < 1) {
		alert("id를 입력하세요.");
		return false;
	}
	
	$.post(
		'/member/ID.do',
		{ "id" : idvalue },
		function(res) {
			$('#idspan').html(res.sw).css('color', 'red');
		},
		'json'
	)
	
	

/*	$.ajax({

		url: '/member/ID.do',
		type: 'post',
		data: '/member/ID.do',
		success: function(res) {
			$('#idspan').html(res.sw).css('color', 'red');
		},
		error: function(xhr) {
			alert("상태 : " + xhr.status);
		},
		dataType: 'json'
	})	*/
}

// 우편번호 검색 - window
$('#wzipbtn').on('click', function() {
	// 새로운 창 열기
	window.open("zipsearch.html", "_blank", "width=500 height=400"); //우편번호찾기
	//(_self, _blank) 위치에는 물리적이름이 아닌 논리적이름이라 실제 보이진 않음
})

//우편번호 검색 - modal - 별도의 이벤트 핸들러 없음
// <button class="btn btn-success btn-sm" id="mzipbtn" data-toggle="modal" data-target="#myModal" type="button">번호검색(modal)</button>

// 우편번호 modal에서 동 입력 후 확인버튼 클릭 이벤트


function dongsearch() {
	// 입력한 값 가져오기
	dongvalue = $('#dong').val().trim();

	//서버로 전송(요청)
	$.ajax({
		url: '/member/DongSearch.do',
		data: { "dong": dongvalue },
		type: 'post',
		success: function(res) {

			code = "<table class='table table-striped' border = '1'>";
			code += "<tr><td>우편번호</td>";
			code += "<td>주소</td>";
			code += "<td>번지</td></tr>";

			$.each(res, function(i, v) {
				code += "<tr class='ziptr'><td>" + v.code + "</td>";
				code += "<td>" + v.addr + "</td>";
				code += "<td>" + v.bunji + "</td></tr>";
			})
			code += "</table>";
			$('#result1').html(code);
		},
		error: function(xhr) {
			alert("상태 : " + xhr.status); // 200, 404, 403(요청오류)
		},
		dataType: 'json'
	})
}

// modal 결과에서 원하는 행(주소)를 선택했을 때 이벤트
// 동적으로 새롭게 생성된 요소 - delegate요소
function zipselect(tt) {

	// 선택
	zipcode = $('td:eq(0)', tt).text();
	addr = $('td:eq(1)', tt).text();

	// 폼에 출력
	$('#zip').val(zipcode);
	$('#add1').val(addr);

	// 모달창 닫기
	$('#myModal').modal('hide');

	// 모달창 내용 지우기
	$('#dong').val("");
	$('#result1').empty();


}

// 제출버튼 클릭 이벤트
// $('button:submit').on('click', function(){ })
// $('button[type=submit]').on('click', function(){ })
function fsubmit() {
	// submit의 고유기능을 방지한다.
	event.preventDefault();

	// 입력한 모든 값(9개)을 가져온다.
	/* idvalue = $('#id').val().trim();
	namevalue = $('#name').val().trim();
	birvalue = $('#bir').val().trim();
	emailvalue = $('#email').val().trim();
	pwdvalue = $('#pwd').val().trim();
	zipvalue = $('#zip').val().trim();
	hpvalue = $('#hp').val().trim();
	add1value = $('#add1').val().trim();
	add2value = $('#add2').val().trim();
    
	datas = {"mem_id" : idvalue, "mem_name" : namevalue, "mem_bir" : birvalue, "mem_email" : emailvalue,
		  "mem_pass" : pwdvalue, "mem_zip" : zipvalue, "mem_hp" : hpvalue, "mem_add1" : add1value, "mem_add2" : add2value};
    
	console.log(datas);
    
	datas = "mem_id=" + idvalue + "&mem_name=" + namevalue + "&mem_bir=" + birvalue + "&mem_mail=" + emailvalue + "&mem_pass=" + 
	pwdvalue + "&mem_zip=" + zipvalue + "&mem_hp=" + hpvalue + "&mem_add1=" + add1value + "&mem_add2=" + add2value;
    
	console.log(datas); */

	console.log($('#ff').serialize());
	console.log($('#ff').serializeArray());
	console.log($('#ff').serializeJSON());


	$.ajax({
		url: '/member/insert.do', // insertMember.do
		method: 'post',
		data: $('#ff').serializeJSON(),
		success: function(res) {
			$('#subspan').html(res.res);
		},
		error: function(xhr) {
			alert("상태 : " + xhr.status);
		},
		dataType: 'json'

	})
}