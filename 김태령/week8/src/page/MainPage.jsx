import Movie from "/src/components/Movie";

function MainPage({ movies, onToggle, onDelete }) {
  return (
    <div className="main-container">
      <div className="movie-grid">
        
        {movies.map((movie) => (
          <Movie
            key={movie.id}
            movie={movie}
            onToggle={onToggle}
            onDelete={onDelete}
          />
        ))}
      </div>
    </div>
  );
}

export default MainPage;
