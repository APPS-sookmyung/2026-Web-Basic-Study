function Movie({ movie }) {     
  return (
    <div className="movie-card">
      
      <div className="poster-container">
        <img src={movie.posterImgUrl} alt={movie.title} />
      </div>

      
      <div className="movie-info">
        <h2>{movie.title}</h2>
        <p className="subtitle">{movie.subTitle}</p>

        
        <ul className="genres">
          {movie.genres.map((genre, index) => (
            <li key={index}>{genre}</li>
          ))}
        </ul>

                
        <p className="description">
          {movie.description.length > 100
            ? movie.description.substring(0, 100) + "..."
            : movie.description} 
        </p>
      </div>
    </div>
  );
}

export default Movie;