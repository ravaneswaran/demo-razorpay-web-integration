<html>
   <head>
      <title>Product Listing</title>
      <jsp:include page="../pages/css/main-css.jsp"/>
      <jsp:include page="../pages/css/products/product-listing-css.jsp"/>
      <jsp:include page="../pages/javascript/main-javascript.jsp"/>
   </head>
   <body>
      <div class="wrapper">
         <div class="header">
            <div class="caption">
               Product Listing
            </div>
            <div class="background-image"></div>            
            <div id="cssmenu">
               <jsp:include page="../pages/menu-bar/menu-bar.jsp"/>
         	</div>
         </div>
         <div class="content-panel">
            <jsp:include page="../pages/body/product-listing-body.jsp"/>
         </div>
         <div class="sitemap">
            <jsp:include page="../pages/sitemap/sitemap.jsp"/>
         </div>
         <div class="footer">
            <jsp:include page="../pages/footer/footer.jsp"/>
         </div>
      </div>
      <script>
        	function toggleSelect(id){
        		var backgroundColor = $(id).css("background-color");
        		if(backgroundColor == "rgb(255, 255, 255)"){
        			$(id).css("background-color", "#2ecc71");
        		} else {
        			$(id).css("background-color", "#ffffff");
        		}
        	}
        	
        	function showOrHideInfoBar(id){
        		$(id).toggle(0);
        	}

        </script>
   </body>
</html>
