<html>
    <head>
        <title>Product Listing</title>
        <jsp:include page="html-head/css.jsp"/>
        <jsp:include page="html-head/javascript.jsp"/>
    </head>
    <body>
        <div class="wrapper">
            <div class="header">
                <jsp:include page="header/home-header.jsp"/>
            </div>
            <div class="body-container">
            	<div class="product-wrapper">
            		<div class="product-container">
            		
            			<div class="product-outer-div" id="1">
		                	<div class="product-inner-div">
		                		<img class="product-image" src="../images/products/xiaomi-redmi-7.jpeg" onclick="toggleSelect('#1')" onmouseenter="showOrHideInfoBar('#1-1')" onmouseleave="showOrHideInfoBar('#1-1')"/>
		                		
		                	</div>
		                	<div class="product-info-slider" id="1-1" onmouseenter="showOrHideInfoBar('#1-1')" onmouseleave="showOrHideInfoBar('#1-1')">
		                		<div class="product-info"></div>
		                	</div>
		                </div>
	                
		                <div class="product-outer-div" id="2">
		                	<div class="product-inner-div">
		                		<img class="product-image" src="../images/products/xiaomi-mi-play.jpeg" onclick="toggleSelect('#2')" onmouseenter="showOrHideInfoBar('#2-1')" onmouseleave="showOrHideInfoBar('#2-1')"/>
		                	</div>
		                	<div class="product-info-slider" id="2-1" onmouseenter="showOrHideInfoBar('#2-1')" onmouseleave="showOrHideInfoBar('#2-1')">
		                		<div class="product-info"></div>
		                	</div>
		                </div>
	                
		                <div class="product-outer-div" id="3">
		                	<div class="product-inner-div">
		                		<img class="product-image" src="../images/products/xiaomi-mi-a3-redmi-pro.jpeg" onclick="toggleSelect('#3')" onmouseenter="showOrHideInfoBar('#3-1')" onmouseleave="showOrHideInfoBar('#3-1')"/>
		                	</div>
		                	<div class="product-info-slider" id="3-1" onmouseenter="showOrHideInfoBar('#3-1')" onmouseleave="showOrHideInfoBar('#3-1')">
		                		<div class="product-info"></div>
		                	</div>
		                </div>
		                
		                 <div class="product-outer-div" id="4">
		                	<div class="product-inner-div">
		                		<img class="product-image" src="../images/products/motorola-p40.jpeg" onclick="toggleSelect('#4')" onmouseenter="showOrHideInfoBar('#4-1')" onmouseleave="showOrHideInfoBar('#4-1')"/>
		                	</div>
		                	<div class="product-info-slider" id="4-1" onmouseenter="showOrHideInfoBar('#4-1')" onmouseleave="showOrHideInfoBar('#4-1')">
		                		<div class="product-info"></div>
		                	</div>
		                </div>
		                
		                <div class="product-outer-div" id="5">
		                	<div class="product-inner-div">
		                		<img class="product-image" src="../images/products/motorola-one-power.jpeg" onclick="toggleSelect('#5')" onmouseenter="showOrHideInfoBar('#5-1')" onmouseleave="showOrHideInfoBar('#5-1')"/>
		                	</div>
		                	<div class="product-info-slider" id="5-1" onmouseenter="showOrHideInfoBar('#5-1')" onmouseleave="showOrHideInfoBar('#5-1')">
		                		<div class="product-info"></div>
		                	</div>
		                </div>
		                
		                <div class="product-outer-div" id="6">
		                	<div class="product-inner-div">
		                		<img class="product-image" src="../images/products/motorola-p40.jpeg" onclick="toggleSelect('#6')" onmouseenter="showOrHideInfoBar('#6-1')" onmouseleave="showOrHideInfoBar('#6-1')"/>
		                	</div>
		                	<div class="product-info-slider" id="6-1" onmouseenter="showOrHideInfoBar('#6-1')" onmouseleave="showOrHideInfoBar('#6-1')">
		                		<div class="product-info"></div>
		                	</div>
		                </div>
	                
		                <div class="product-outer-div" id="7">
		                	<div class="product-inner-div">
		                		<img class="product-image" src="../images/products/moana.jpeg" onclick="toggleSelect('#7')" onmouseenter="showOrHideInfoBar('#7-1')" onmouseleave="showOrHideInfoBar('#7-1')"/>
		                	</div>
		                	<div class="product-info-slider" id="7-1" onmouseenter="showOrHideInfoBar('#7-1')" onmouseleave="showOrHideInfoBar('#7-1')">
		                		<div class="product-info"></div>
		                	</div>
		                </div>
	                
		                <div class="product-outer-div" id="8">
		                	<div class="product-inner-div">
		                		<img class="product-image" src="../images/products/shrek.jpeg" onclick="toggleSelect('#8')" onmouseenter="showOrHideInfoBar('#8-1')" onmouseleave="showOrHideInfoBar('#8-1')"/>
		                	</div>
		                	<div class="product-info-slider" id="8-1" onmouseenter="showOrHideInfoBar('#8-1')" onmouseleave="showOrHideInfoBar('#8-1')">
		                		<div class="product-info"></div>
		                	</div>
		                </div>
		                
		                 <div class="product-outer-div" id="9">
		                	<div class="product-inner-div">
		                		<img class="product-image" src="../images/products/dragon.jpeg" onclick="toggleSelect('#9')" onmouseenter="showOrHideInfoBar('#9-1')" onmouseleave="showOrHideInfoBar('#9-1')"/>
		                	</div>
		                	<div class="product-info-slider" id="9-1" onmouseenter="showOrHideInfoBar('#9-1')" onmouseleave="showOrHideInfoBar('#9-1')">
		                		<div class="product-info"></div>
		                	</div>
		                </div>
		                
            		</div>
             	</div>
            </div>
            <div class="sitemap">
                <jsp:include page="sitemap/sitemap.jsp"/>
            </div>
            <div class="copyright">
                <jsp:include page="footer/footer.jsp"/>
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
