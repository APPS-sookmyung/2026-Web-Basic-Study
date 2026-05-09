import { useParams } from "react-router-dom";
import movieData from "../mock/dummy.json";
import "./MoviePage.css";

function MoviePage() {
  const { id } = useParams();
  const movie = movieData.find((m) => m.id === Number(id));

  if (!movie) {
    return <div className="error">영화를 찾을 수 없습니다.</div>;
  }

  return (
    <div className="movie-detail-container">
      <div className="detail-poster">
        <img src={movie.posterImgUrl} alt={movie.title} />
      </div>

      <div className="detail-content">
        <h1>{movie.title}</h1>
        <p className="detail-subtitle">{movie.releaseDate}</p>

        <div className="detail-genres">
          {movie.genres.map((genre) => (
            <span key={genre}>{genre}</span>
          ))}
        </div>

        <div className="detail-summary">
          <p>{movie.description}</p>
        </div>
      </div>
    </div>
  );
}

export default MoviePage;
