import { useState } from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import movieData from "./mock/dummy.json"; // 원본 데이터
import Header from "./components/Header";
import MainPage from "./page/MainPage";
import FavoritePage from "./page/FavoritePage";
import MoviePage from "./page/MoviePage";
import AddMoviePage from "./page/AddMoviePage";

import "./App.css";

export default function App() {
  // 1. 모든 영화 데이터에 isLiked 속성을 추가하여 상태(State)로 관리합니다.
  const [movies, setMovies] = useState(
    movieData.map((movie) => ({ ...movie, isLiked: false })),
  );


  const [searchTerm, setSearchTerm] = useState("");

  // 2. 하트를 누를 때 실행될 함수 (상태 변경 로직)
  // 기존 영화 배열을 순회하며, id가 일치하는 영화의 isLiked 상태만 반전시킨 새로운 배열을 반환
  const toggleHeart = (id) => {
    setMovies((prevMovies) =>
      prevMovies.map((movie) =>
        movie.id === id ? { ...movie, isLiked: !movie.isLiked } : movie,
      ),
    );
  };


  const deleteMovie = (id) => {
    // 확인 창을 띄워 사용자에게 재확인 받습니다.
    if (window.confirm("정말로 이 영화를 삭제하시겠습니까?")) {
      setMovies((prevMovies) => prevMovies.filter((movie) => movie.id !== id));
    }
  };

  const handleSearch = (e) => {
    setSearchTerm(e.target.value);
  };


  const filteredMovies = movies.filter((movie) =>
    movie.title.toLowerCase().includes(searchTerm.toLowerCase())
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
        {/* FavoritePage에는 '좋아요'한 영화만 걸러서(filter) 넘겨줍니다. */}
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
        {/* 동적 라우팅 */}
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
        {/* 영화 추가 라우트 추가 및 Props 전달 */}
        {/* 영화 추가 페이지를 위한 동적 라우팅을 작성해 봅시다. 주소 경로는 '/add'로 설정합니다. */}
        <Route
          path="/add"
          element={<AddMoviePage movies={movies} setMovies={setMovies} />}
        />
      </Routes>
    </BrowserRouter>
  );
}
