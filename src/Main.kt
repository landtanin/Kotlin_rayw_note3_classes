class MovieList(val genre: String) {
    private val movies = ArrayList<String>()

    fun addMovie(movie: String) {
        movies.add(movie)
    }

    fun print() {
        println("Movie List: $genre")
        for (movie in movies) {
            print("$movie ")
        }
        println()
    }
}

class MovieGoer{
    private var movieList = HashMap<String, MovieList>()

//    fun addList(list: MovieList) {
//        movieList[list.genre] = list
//    }

    fun addGenre(genre: String) {
        movieList[genre] = MovieList(genre)
    }

    fun movieListFor(genre: String) : MovieList? {
        return movieList[genre]
    }

    fun addMovie(genre: String, movie: String) {
        if (!movieList.containsKey(genre)) {
            addGenre(genre)
        }
        movieList[genre]?.addMovie(movie)
    }
}

fun main(args: Array<String>) {

//    // initializer
//    class Person(var firstName: String, var lastName: String) {
//
//        var fullName: String
//        init {
//            fullName = firstName + " " + lastName
//        }
//
//    }
//
//    var person = Person("Sam", "Gamgee")
//    println(person.fullName)

    val jane = MovieGoer()
    val john = MovieGoer()
//    val actionList = MovieList("Action")
//
//    jane.addList(actionList)
//    john.addList(actionList)

    jane.addMovie("Action", "Rambo")
    jane.addMovie("Action", "The Matrix")

    john.addMovie("Action", "The Dark Night")

    jane.movieListFor("Action")?.print()
    john.movieListFor("Action")?.print()

}

