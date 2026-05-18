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
        <img src={movie.poster_path} alt={movie.title} />
      </div>
    </div>
  );
}

export default MoviePage;
