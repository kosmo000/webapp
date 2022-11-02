/*
(1) 오늘 날짜 출력 (10점)
  (2) 포커스 가면 ‘검색어를 입력하세요’를 안보이고 다시 포커스가 없으면 다시 출력 (10점)
  (3) 탭팬 구현 (10점)
  (4) 이미지슬라이드 구현 (10점)
  (5) [로그인]을 누르면 로그인 창이 보이고 [Close]를 누르면 다시 안 보임  (20점)
  (6) [전체메뉴]를 선택하면 전체메뉴가 보이고 [Close] 누르면 다시 안 보임 (20점)
  (7) 그 외 추가적으로 구현하면 해당 화면 캡쳐하고 코드를 작성합니다. (20점)
*/
//1.
$(function(){
	var today = new Date();
	var year = today.getFullYear();
	var month = today.getMonth()+1;
	let date = today.getDate(); 
	console.log(year + '-' + month + '-' + date);

	
	
	$('.year').text(year)
	$('.month').text(month)
	$('.date').text(date)
//2.
	$('#keyword').focus(function(){
		$('#keyword').css('background','url("")')
		});
		
	$('#keyword').blur(function(){
		$('#keyword').css('background','url("./images/sch_guide.gif") no-repeat')
	})
 
	
//3.
 $('#tabmenu dt').click(function() {
      $('#tabmenu dd').hide();
      $(this).next('dd').show();
   });
 	$('#tabmenu dt.tab_btn1 a img').click(function() {
         $('#tabmenu dt.tab_btn2 a img').attr('src', $('#tabmenu dt.tab_btn2 a img').attr('src').replace("over", "out"));
         $('#tabmenu dt.tab_btn3 a img').attr('src', $('#tabmenu dt.tab_btn3 a img').attr('src').replace("over", "out"));
         $(this).attr('src', $(this).attr('src').replace("out", "over"));
      })
      $('#tabmenu dt.tab_btn2 a img').click(function() {
         $('#tabmenu dt.tab_btn1 a img').attr('src', $('#tabmenu dt.tab_btn1 a img').attr('src').replace("over", "out"));
         $('#tabmenu dt.tab_btn3 a img').attr('src', $('#tabmenu dt.tab_btn3 a img').attr('src').replace("over", "out"));
         $(this).attr('src', $(this).attr('src').replace("out", "over"));
      })
      $('#tabmenu dt.tab_btn3 a img').click(function() {
         $('#tabmenu dt.tab_btn2 a img').attr('src', $('#tabmenu dt.tab_btn2 a img').attr('src').replace("over", "out"));
         $('#tabmenu dt.tab_btn1 a img').attr('src', $('#tabmenu dt.tab_btn1 a img').attr('src').replace("over", "out"));
         $(this).attr('src', $(this).attr('src').replace("out", "over"));
      })
   
   $('#tabmenu dt').click(function() {

      $('#tabmenu dd').hide();
      $(this).next('dd').show();

      var src = $('#tabmenu dt a img');
      for (var i = 0; i < src.length; i++) {
         let eq = src.eq(i)
         eq.attr('src', eq.attr('src').replace('over', 'out'));
      }
      var img = $(this).find('img')
      img.attr('src', img.attr('src').replace('out', 'over'));

   });

  
  
 
//4.
	 $(document).ready(function(){
    $('#best_bg ul').bxSlider({
		minSlides : 5,			// 한 번에 보일 최소 이미지 수
		maxSlides : 5,			// 한 번에 보일 최대 이미지 수
		slideMargin : 10,		// 이미지와 이미지 사이의 여백
		slideWidth : 200,		// 슬라이드 전체 폭
		auto: true,				// 자동 재생
		autoControls: false,		// 재생 버튼
		stopAutoOnClick: false,
		pager: false,			// 페이지 단추 보일지 안 보일지 
		moveSlides : 1,			// 슬라이드가 몇 장씩 움직일지
		speed :300,				// 슬라이드 속도 (1000 = 1초)
		pause : 1000
	});
});

//5.
	$('.login_wrap img').click(function() {
   $('#login_f').css('top', '18px')
})

$('.login_close_btn img').click(function() {
   $('#login_f').css('top', '-220px')
})

//6.
$('#total_btn > a > img').click(function() {
   $('#total_menu').show();
})

$('#total_close > a > img').click(function() {
   $('#total_menu').hide();
})
//7. 
$('#header h1 a img').click(function() {
   location.reload();
})

 $('.zoom_in').click(function() {
      $('body').css({ 'zoom': '+=.1%' });
   })
   $('.zoom_out').click(function() {
      $('body').css({ 'zoom': '-=.1%' });
   })

	       
});



