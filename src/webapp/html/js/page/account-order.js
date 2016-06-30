append_tbody();
function append_tbody(){
	var content_html = "";
	for (var i = 0; i < 11; i++) {
		var item =  <div class="order-top">
					<div class="order-id">
						<b>
							订单号：1101110
						</b>
						<b class="order-time">
							2016-06-11
						</b>
					</div>

					<div class="pic-inf-attr2">
						<div class="pic01">
							<img src="images/product.jpg">
						</div>
						<div class="attr00">
							<span class="informations">
								<a href="single.html">赛睿（SteelSeries）</br>平民价格 竞赛品质 小手玩家适用 赛睿微动</a></span>
							<div class="attributes00">
								<ul class="list-inline">
									<li>款式：<span class="badge">黑色</span></li>
									<li>数量：<span class="badge">1</span></li>
								</ul>
							</div>
						</div>
						<div class="attr02">
							<span class="attributes">价格:<b>￥199</b></span>
						</div>
					</div>

					<div class="order-message">
						留言：BIBIBIBIBIBI
						<b class="order-time">
								<div class="attr03">
								总价   : <span class="total-money">￥199</span>
								</div>
							<b> 订单状态: </b>
						<b class="order-money">已发货</b>
						</b>
					</div>

				</div>
		
		content_html+=item;
	}
	
	var item2 =
		$("#table_content").empty();
		$("#table_content").append(content_html);
     
}

