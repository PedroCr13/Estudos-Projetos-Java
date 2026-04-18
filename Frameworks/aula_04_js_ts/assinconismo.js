// import fetch from 'node-fetch'; versao 24 do node vem embutido o pacote fetch

const resposta = fetch('http://api.postmon.com.br/v1/cep/80230901');

resposta.then(data => data.json())
    .then(data => {console.log(data) })
    .catch(erro => {console.log(erro)});