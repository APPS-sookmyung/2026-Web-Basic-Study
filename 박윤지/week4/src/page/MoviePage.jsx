// react-router-dom 라이브러리에서 useParmas 함수 import
import { useParams } from "react-router-dom";
import movieData from "../mock/dummy.json";
import "./MoviePage.css";

function MoviePage() {
  // useParmas() : 주소창의 파라미터들을 객체 형태로 가져옴
  // { id } : 객체에서 id라는 값만 꺼내서 사용 (구조 분해 할당) 
  const { id } = useParams();

  // find() : 배열에서 테스트 함수를 만족하는 첫 번째 요소 반환
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
        <p className="detail-subtitle">{movie.subTitle}</p>

        <div className="detail-genres">
          {movie.genres.map((genre, index) => (
            <span key={index}>{genre}</span>
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
