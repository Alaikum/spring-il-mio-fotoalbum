console.log("show")
const URLParams = new URLSearchParams(window.location.search);
console.log('Foto ID:', URLParams.get("id"))
const fotoId = URLParams.get("id");

axios.get(`http://localhost:8080/api/foto/${fotoId}`).then((res) => {
    console.log(res)
    foto = res.data
    if (foto.visibile) {


        document.querySelector("#foto__foto").src = foto.url
        document.querySelector("#foto__titolo").innerHTML += foto.titolo
        document.querySelector("#foto__descrizione").innerHTML += foto.descrizione
        document.querySelector("#foto__tag").innerHTML += foto.tag
        if (foto.categorie.length > 0) {
            foto.categorie.forEach(c => {
                document.querySelector("#c__nome").innerHTML += c.nome + " "
            });
        } else {
            document.querySelector("#c__nome").innerHTML += "Per questa foto non ci sono categorie assegnate!"
        }

        if (foto.commenti.length > 0) {
            foto.commenti.forEach(com => {
                document.querySelector("#commenti").innerHTML += `
        <span class="text-danger">Autore:</span> <span class="text-dark" id="com__nome">${com.nome}</span>
        <li><span class="text-secondary">Testo:</span> <span class="text-dark" id="com__descrizione">${com.descrizione}</span></li>
        `

            });
        } else {
            document.querySelector("#commenti").innerHTML += "Per questa foto non ci sono commenti!"
        }
    } else {
        document.querySelector(".container").innerHTML = "<h1>Foto non più Visibile</h1><p>Contatta il proprietarò Del Sito</p> <h4><a href='/frontend'>Torna alla Home</a></h4>"
    }
}).catch((res) => {
    console.log("not ok", res)
})


function creaCommento(event) {
    // event.preventDeafault();
    const commento = {
        nome: document.querySelector('#nome').value,
        descrizione: document.querySelector('#descrizione').value
    }


    axios.post(`http://localhost:8080/api/foto/${fotoId}/commenti`, commento).then((res) => {
        console.log("commento salavato")
        location.href = `/frontend/show?id=${fotoId}`
    }).catch((res) => {
        console.log("errore nei commenti")
        location.href = `/frontend/show?id=${fotoId}`
     
    })
}

