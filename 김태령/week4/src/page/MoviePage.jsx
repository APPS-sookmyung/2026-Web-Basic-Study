import { useParams } from "react-router-dom";
import movieData from "../mock/dummy.json";
import "./MoviePage.css";

function MoviePage() {
  // 1. URL에서 :id 값을 가져옵니다.
  const { id } = useParams();

  // 2. 전체 데이터 중 ID가 일치하는 영화 하나만 찾습니다.
  // URL의 id는 문자열이므로 숫자로 변환(Number)하여 비교합니다.
  const movie = movieData.find((m) => m.id === Number(id));

  // 데이터를 찾지 못했을 때의 예외 처리
  if (!movie) {
    return <div className="error">영화를 찾을 수 없습니다.</div>;
  }

  return (
    <div className="movie-detail-container">
      {/* 상단: 큰 포스터 이미지 */}
      <div className="detail-poster">
        <img src={movie.posterImgUrl} alt={movie.title} />
      </div>

      {/* 하단: 영화 상세 정보 */}
      <div className="detail-content">
        <h1>{movie.title}</h1>
        <p className="detail-subtitle">{movie.subTitle}</p>

        // 영화 장르 정보 - map 이용
        <div className="detail-genres">
          {movie.genres.map((genre, index) => (
            <span key={index}>{genre}</span>
          ))}
        </div>

        // 영화 description 정보
        <div className="detail-summary">
          <p>{movie.description}</p>
        </div>
      </div>
    </div>
  );
}

export default MoviePage;