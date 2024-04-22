function consultarRestaurantes() {
  $.ajax({
    url: "http://www.algafood.local:8080/restaurantes",
    type: "get",

    success: function(response) {
      console.log(response);
      $("#conteudo").text(response);
    }
  });
}

$("#botao").click(consultarRestaurantes);