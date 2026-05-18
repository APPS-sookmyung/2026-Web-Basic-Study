// Movie 컴포넌트는 부모로부터 movie 객체를 전달받습니다.
function Movie({ movie }) {
  return (
    
      <div className="movie-card">
        {/* 1. 포스터 영역 */}
        <div className="poster-container">
          <img src={movie.posterImgUrl} alt={movie.title} />
        </div>

        {/* 2. 상세 정보 영역 */}
        <div className="movie-info">
          <h2>{movie.title}</h2>
          <p className="subtitle">{movie.subTitle}</p>

          {/* 장르 리스트 매핑 */}
          <ul className="genres">
            {movie.genres.map((genre, index) => (
              <li key={index}>{genre}</li>
            ))}
          </ul>

          {/* 설명 (summary) */}
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
