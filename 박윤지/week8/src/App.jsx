import { useState, useEffect } from "react"; // ⭐ useEffect 추가 
import { BrowserRouter, Routes, Route } from "react-router-dom";
// import movieData from "./mock/dummy.json"; // ⭐ 기존 로컬 데이터 임포트 제거
import Header from "./components/Header";
import MainPage from "./page/MainPage";
import FavoritePage from "./page/FavoritePage";
import MoviePage from "./page/MoviePage";
import AddMoviePage from "./page/AddMoviePage";

import "./App.css";

export default function App() {
  // ⭐ 초기 상태를 기존 dummy.json 데이터 매핑 대신 빈 배열([])로 설정
  const [movies, setMovies] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");

  // ⭐ TMDB API 연동을 위한 주소 설정
  const API_KEY = import.meta.env.VITE_TMDB_API_KEY;
  const API_URL = `https://api.themoviedb.org/3/movie/popular?api_key=${API_KEY}&language=ko-KR&page=1`;

  // ⭐ 컴포넌트 마운트 시 외부 영화 API를 딱 한 번 비동기로 가져오는 useEffect 안전 펜스
  useEffect(() => {
    const fetchMovies = async () => {
      try {
        // 1. fetch API 이용해 서버에 데이터 요청
        const response = await fetch(API_URL);
        if (!response.ok) {
          throw new Error("네트워크 응답에 실패했습니다.");
        }

        // 2. 받아온 response 응답을 위해 json 형태로 파씽
        const data = await response.json();

        // ⭐ 3. TMDB 데이터를 서비스 규격에 맞게 가공
        const formattedMovies = data.results.map((movie) => ({
          ...movie,
          isLiked: false,
          posterImgUrl: movie.poster_path
            ? `https://image.tmdb.org/t/p/w500${movie.poster_path}`
            : "https://via.placeholder.com/500x750?text=No+Poster",
          subTitle: movie.original_title,
          description: movie.overview,
          genres: movie.genre_ids.map((id) => "영화"),
        }));
        
        // 4. 가공 완료된 배열을 상태 변수에 주입
        setMovies(formattedMovies);
      } catch (error) {
        console.error("영화 API를 가져오는 중 오류 발생:", error);
      }
    };

    // 비동기 함수 실행
    fetchMovies();
  }, []); // ⭐ 5. 최초 1회만 호출되도록 관리하는 빈 의존성 배열

  const toggleHeart = (id) => {
    setMovies((prevMovies) =>
      prevMovies.map((movie) =>
        movie.id === id ? { ...movie, isLiked: !movie.isLiked } : movie,
      ),
    );
  };

  const deleteMovie = (id) => {
    if (window.confirm("정말로 이 영화를 삭제하시겠습니까?")) {
      setMovies((prevMovies) => prevMovies.filter((movie) => movie.id !== id));
    }
  };

  const handleSearch = (e) => {
    setSearchTerm(e.target.value);
  };

  const filteredMovies = movies.filter((movie) =>
    movie.title.toLowerCase().includes(searchTerm.toLowerCase()),
  );

  return (
    <BrowserRouter>
      <Header onSearch={handleSearch} />
      <Routes>
        <Route
          path="/"
          element={
            <MainPage
              movies={filteredMovies}
              onToggle={toggleHeart}
              onDelete={deleteMovie}
            />
          }
        />
        <Route
          path="/favorites"
          element={
            <FavoritePage
              movies={movies.filter((m) => m.isLiked)}
              onToggle={toggleHeart}
              onDelete={deleteMovie}
            />
          }
        />
        <Route
          path="/movie/:id"
          element={
            <MoviePage
              movies={movies}
              onToggle={toggleHeart}
              onDelete={deleteMovie}
            />
          }
        />
        <Route
          path="/add"
          element={<AddMoviePage movies={movies} setMovies={setMovies} />}
        />
      </Routes>
    </BrowserRouter>
  );
}
