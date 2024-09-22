document.addEventListener('DOMContentLoaded', function() {
  const inputTexto = document.getElementById('inputTexto');
  const outputTexto = document.getElementById('outputTexto');
  const criptoButton = document.querySelector('.cripto');
  const descriptoButton = document.querySelector('.descripto');
  const outputCopyButton = document.querySelector('.outputCopy');

  const criptoMap = {
      'e': 'enter',
      'i': 'imes',
      'a': 'ai',
      'o': 'ober',
      'u': 'ufat'
  };

  function invertMap(map) {
      const invertedMap = {};
      for (const key in map) {
          invertedMap[map[key]] = key;
      }
      return invertedMap;
  }

  const descriptoMap = invertMap(criptoMap);

  function criptografar(texto) {
      return texto.split('').map(char => criptoMap[char] || char).join('');
  }

  function descriptografar(texto) {
      let textoDescriptografado = texto;
      for (const key in descriptoMap) {
          const regex = new RegExp(key, 'g');
          textoDescriptografado = textoDescriptografado.replace(regex, descriptoMap[key]);
      }
      return textoDescriptografado;
  }

  criptoButton.addEventListener('click', function() {
      const textoOriginal = inputTexto.value.toLowerCase();
      const textoCriptografado = criptografar(textoOriginal);
      outputTexto.value = textoCriptografado;
  });

  descriptoButton.addEventListener('click', function() {
      const textoCriptografado = inputTexto.value.toLowerCase();
      const textoDescriptografado = descriptografar(textoCriptografado);
      outputTexto.value = textoDescriptografado;
  });

  outputCopyButton.addEventListener('click', function() {
      outputTexto.select();
      document.execCommand('copy');
      window.getSelection().removeAllRanges();
  });
});