import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import Header from "./components/Header";
import MainPage from "./page/MainPage";
import MoviePage from "./page/MoviePage";

export default function App() {
  return (
    <BrowserRouter>
      <Header />
      <Routes>
        <Route path="/" element={<MainPage />} />
        {/* 동적 라우팅 */}
        <Route path="/movie/:?" element={<MoviePage />} />
      </Routes>
    </BrowserRouter>
  );
}
