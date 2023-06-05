import { CriarColecao } from './Criar_Colecao_Set.js';

const obj = [
  {
    "titulo": "1984",
    "autor": "George Orwell",
    "editora": "Secker & Warburg",
    "resumo": "1984 é um romance distópico escrito por George Orwell em 1949. O livro retrata uma sociedade totalitária controlada pelo Partido, onde a liberdade individual é suprimida e a vigilância constante é imposta.",
    "ebook": "https://exemplo.com/1984-ebook"
  },
  {
    "titulo": "O Sol é para Todos",
    "autor": "Harper Lee",
    "editora": "J. B. Lippincott & Co.",
    "resumo": "O Sol é para Todos é um romance escrito por Harper Lee e publicado em 1960. O livro aborda questões de racismo e injustiça social nos Estados Unidos da década de 1930, através da história de Scout Finch e seu pai.",
    "ebook": "https://exemplo.com/o-sol-e-para-todos-ebook"
  },
  {
    "titulo": "Dom Quixote",
    "autor": "Miguel de Cervantes",
    "editora": "Francisco de Robles",
    "resumo": "Dom Quixote é um romance escrito por Miguel de Cervantes e publicado em 1605. A obra é considerada uma das mais importantes da literatura espanhola e retrata as aventuras do cavaleiro enlouquecido Dom Quixote e seu fiel escudeiro Sancho Pança.",
    "ebook": "https://exemplo.com/dom-quixote-ebook"
  },
  {
    "titulo": "A Revolução dos Bichos",
    "autor": "George Orwell",
    "editora": "Secker & Warburg",
    "resumo": "A Revolução dos Bichos é uma fábula escrita por George Orwell em 1945. O livro satiriza os regimes totalitários através da história dos animais de uma fazenda que se rebelam contra seus donos humanos, mas acabam por estabelecer uma nova forma de opressão.",
    "ebook": "https://exemplo.com/a-revolucao-dos-bichos-ebook"
  },
  {
    "titulo": "Cem Anos de Solidão",
    "autor": "Gabriel García Márquez",
    "editora": "Editorial Sudamericana",
    "resumo": "Cem Anos de Solidão é um romance escrito por Gabriel García Márquez e publicado em 1967. A obra é considerada um clássico do realismo mágico e conta a história da família Buendía ao longo de várias gerações na fictícia cidade de Macondo.",
    "ebook": "https://exemplo.com/cem-anos-de-solidao-ebook"
  },
  {
    "titulo": "A Metamorfose",
    "autor": "Franz Kafka",
    "editora": "Kurt Wolff Verlag",
    "resumo": "A Metamorfose é uma novela escrita por Franz Kafka e publicada em 1915. A obra narra a história de Gregor Samsa, que acorda certa manhã transformado em um inseto e explora temas como a alienação e a incomunicabilidade humana.",
    "ebook": "https://exemplo.com/a-metamorfose-ebook"
  },
  {
    "titulo": "Orgulho e Preconceito",
    "autor": "Jane Austen",
    "editora": "T. Egerton",
    "resumo": "Orgulho e Preconceito é um romance escrito por Jane Austen e publicado em 1813. O livro acompanha a história de Elizabeth Bennet e sua família, explorando temas como casamento, classe social e preconceito na Inglaterra do século XIX.",
    "ebook": "https://exemplo.com/orgulho-e-preconceito-ebook"
  },
  {
    "titulo": "O Grande Gatsby",
    "autor": "F. Scott Fitzgerald",
    "editora": "Charles Scribner's Sons",
    "resumo": "O Grande Gatsby é um romance escrito por F. Scott Fitzgerald e publicado em 1925. A obra retrata a vida extravagante da alta sociedade americana durante os anos 1920, através dos olhos do narrador Nick Carraway e de seu misterioso vizinho Jay Gatsby.",
    "ebook": "https://exemplo.com/o-grande-gatsby-ebook"
  },
  {
    "titulo": "Moby Dick",
    "autor": "Herman Melville",
    "editora": "Richard Bentley",
    "resumo": "Moby Dick é um romance escrito por Herman Melville e publicado em 1851. A obra narra a obsessão do capitão Ahab em caçar a baleia branca Moby Dick, explorando temas como a natureza humana, o bem e o mal, e a busca pelo sentido da vida.",
    "ebook": "https://exemplo.com/moby-dick-ebook"
  },
  {
    "titulo": "Ulisses",
    "autor": "James Joyce",
    "editora": "Sylvia Beach",
    "resumo": "Ulisses é um romance escrito por James Joyce e publicado em 1922. A obra retrata um único dia na vida de Leopold Bloom e Stephen Dedalus em Dublin, utilizando uma variedade de estilos literários e explorando temas como identidade, sexualidade e o fluxo de consciência.",
    "ebook": "https://exemplo.com/ulisses-ebook"
  },
  {
    "titulo": "A Divina Comédia",
    "autor": "Dante Alighieri",
    "editora": "Desconhecida",
    "resumo": "A Divina Comédia é um poema épico escrito por Dante Alighieri entre 1308 e 1320. A obra descreve a jornada de Dante através do Inferno, Purgatório e Paraíso, explorando temas religiosos, morais e políticos da época.",
    "ebook": "https://exemplo.com/a-divina-comedia-ebook"
  },
  {
    "titulo": "O Morro dos Ventos Uivantes",
    "autor": "Emily Brontë",
    "editora": "Thomas Cautley Newby",
    "resumo": "O Morro dos Ventos Uivantes é um romance escrito por Emily Brontë e publicado em 1847. A obra narra a história tumultuada dos personagens Heathcliff e Catherine Earnshaw em uma propriedade rural no norte da Inglaterra, explorando temas como amor, vingança e redenção.",
    "ebook": "https://exemplo.com/o-morro-dos-ventos-uivantes-ebook"
  },
  {
    "titulo": "O Retrato de Dorian Gray",
    "autor": "Oscar Wilde",
    "editora": "Ward, Lock & Co.",
    "resumo": "O Retrato de Dorian Gray é um romance escrito por Oscar Wilde e publicado em 1890. A obra conta a história de Dorian Gray, um jovem que mantém sua juventude e beleza enquanto seu retrato envelhece e registra os efeitos de seus atos imorais.",
    "ebook": "https://exemplo.com/o-retrato-de-dorian-gray-ebook"
  },
  {
    "titulo": "A Revolta de Atlas",
    "autor": "Ayn Rand",
    "editora": "Random House",
    "resumo": "A Revolta de Atlas é um romance escrito por Ayn Rand e publicado em 1957. A obra apresenta um panorama distópico em que os principais líderes industriais abandonam suas empresas e o mundo mergulha em uma crise econômica, explorando temas como individualismo, empreendedorismo e filosofia política.",
    "ebook": "https://exemplo.com/a-revolta-de-atlas-ebook"
  },
  {
    "titulo": "O Apanhador no Campo de Centeio",
    "autor": "J.D. Salinger",
    "editora": "Little, Brown and Company",
    "resumo": "O Apanhador no Campo de Centeio é um romance escrito por J.D. Salinger e publicado em 1951. O livro narra o período de três dias na vida do adolescente Holden Caulfield, explorando temas como adolescência, alienação e a busca por autenticidade.",
    "ebook": "https://exemplo.com/o-apanhador-no-campo-de-centeio-ebook"
  }
]


const nomeBanco = "Livraria";
const nomeColecao = "livros"; // Coloque o nome da coleção desejada aqui
CriarColecao(nomeColecao, nomeBanco, obj).catch(console.error);

