<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<p>
<form action="result.jsp" method="get">

	<div class="row">
		<div class="two columns">ID</div>
		<div class="six columns"><input class="u-full-width" type="text" placeholder="Üretim IDsi" id="id" name="id"></div>
	</div>
	<div class="row">
		<div class="two columns">Açıklama</div>
		<div class="six columns"><input class="u-full-width" type="text" placeholder="Üretime ait açıklama; * kullanılabilir" id="description" name="description"></div>
	</div>	
	<div class="row">
		<div class="two columns">Müşteri</div>
		<div class="six columns"><input class="u-full-width" type="text" placeholder="Müşterinin adı; * kullanılabilir" id="client" name="client"></div>
	</div>
	<div class="row">
		<div class="two columns">Versiyon</div>
		<div class="six columns"><input class="u-full-width" type="text" placeholder="Üretimin versiyonu; * kullanılabilir" id="version" name="version"></div>
	</div>
	<div class="row">
		<div class="two columns">Etkinlik</div>
		<div class="six columns">
	      <select class="u-full-width" id="active" name="active">
	        <option value="">Hepsi</option>
	        <option value="TRUE">Etkin versiyonlar</option>
	        <option value="FALSE">Eski versiyonlar</option>
	      </select>
		</div>
	</div>
	<div class="row">
		<div class="two columns">Tarih</div>
		<div class="six columns"><input class="u-full-width" type="text" placeholder = "Tarih; &lt; &gt; - kullanılabilir" id="date" name="date"></div>
	</div>
	<div class="row">
		<div class="two columns">Soğutma</div>
		<div class="six columns">
	      <select class="u-full-width" id="cool" name="cool">
	        <option value="">Hepsi</option>
	        <option value="TRUE">Soğutma özelliği olanlar</option>
	        <option value="FALSE">Soğutma özelliği olmayanlar</option>
	      </select>
		</div>
	</div>
	<div class="row">
		<div class="two columns">Isıtma</div>
		<div class="six columns">
	      <select class="u-full-width" id="warm" name="warm">
	        <option value="">Hepsi</option>
	        <option value="TRUE">Isıtma özelliği olanlar</option>
	        <option value="FALSE">Isıtma özelliği olmayanlar</option>
	      </select>
		</div>
	</div>
	<div class="row">
		<div class="two columns">Tasarruf</div>
		<div class="six columns">
	      <select class="u-full-width" id="economy" name="economy">
	        <option value="">Hepsi</option>
	        <option value="TRUE">Tasarruf özelliği olanlar</option>
	        <option value="FALSE">Tasarruf özelliği olmayanlar</option>
	      </select>
		</div>
	</div>
	<div class="row">
		<div class="two columns">Yeniden kazanım</div>
		<div class="six columns">
	      <select class="u-full-width" id="regain" name="regain">
	        <option value="">Hepsi</option>
	        <option value="TRUE">Kazanım özelliği olanlar</option>
	        <option value="FALSE">Kazanım özelliği olmayanlar</option>
	      </select>
		</div>
	</div>
	<div class="row">
		<div class="two columns">Mekan</div>
		<div class="six columns">
	      <select class="u-full-width" id="space" name="space">
	        <option value="">Hepsi</option>
	        <option value="I">İç mekan</option>
	        <option value="E">Dış mekan</option>
	      </select>
		</div>
	</div>
	<div class="row">
		<div class="two columns">Genişlik</div>
		<div class="six columns"><input class="u-full-width" type="text" placeholder="Genişlik; &lt; &gt; - kullanılabilir" id="width" name="width"></div>
	</div>
	<div class="row">
		<div class="two columns">Uzunluk</div>
		<div class="six columns"><input class="u-full-width" type="text" placeholder="Uzunluk; &lt; &gt; - kullanılabilir" id="length" name="length"></div>
	</div>
	<div class="row">
		<div class="two columns">Yükseklik</div>
		<div class="six columns"><input class="u-full-width" type="text" placeholder="Yükseklik; &lt; &gt; - kullanılabilir" id="height" name="height"></div>
	</div>
	<input class="button-secondary" type="submit" value="Sonuçları getir">
</form>
</p>
