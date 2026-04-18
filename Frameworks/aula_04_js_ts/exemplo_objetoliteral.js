var album = {
    title: "Mettalica (Black Album)",
    released: 1991,
    showInfo: function() {
        console.log(`Titulo do album: ${this.title} - Lançado em : ${this.released}`);
    }
};

console.log(album);
album.showInfo();
