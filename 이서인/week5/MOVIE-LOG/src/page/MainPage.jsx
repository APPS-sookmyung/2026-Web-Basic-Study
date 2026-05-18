import React, { useState, useEffect } from 'react';
import Movie from "../components/Movie";
import movieData from "../mock/dummy.json";

export default function MainPage() {
  const [activeTab, setActiveTab] = useState('all'); // 'all' 또는 'favorite'
  const [favoriteMovies, setFavoriteMovies] = useState([]);

  const loadFavorites = () => {
    const savedFavorites = JSON.parse(localStorage.getItem('favorites')) || [];
    setFavoriteMovies(savedFavorites);
  };

  useEffect(() => {
    loadFavorites();
  }, []);

  return (
    <div className="main-container">
      {/* 탭 메뉴 버튼 */}
      <div style={{ display: 'flex', gap: '20px', margin: '20px', justifyContent: 'center' }}>
        <button 
          onClick={() => setActiveTab('all')}
          style={{
            background: 'none', border: 'none', color: activeTab === 'all' ? '#ff4757' : 'white',
            fontSize: '18px', fontWeight: 'bold', cursor: 'pointer'
          }}
        >
          전체 영화
        </button>
        <button 
          onClick={() => setActiveTab('favorite')}
          style={{
            background: 'none', border: 'none', color: activeTab === 'favorite' ? '#ff4757' : 'white',
            fontSize: '18px', fontWeight: 'bold', cursor: 'pointer'
          }}
        >
          내가 찜한 콘텐츠 ({favoriteMovies.length})
        </button>
      </div>

      {/* 영화 그리드 목록 */}
      <div className="movie-grid">
        {activeTab === 'all' ? (
          movieData?.map((movie) => (
            <Movie key={movie.id} movie={movie} onFavoriteChange={loadFavorites} />
          ))
        ) : (
          favoriteMovies.length > 0 ? (
            favoriteMovies.map((movie) => (
              <Movie key={movie.id} movie={movie} onFavoriteChange={loadFavorites} />
            ))
          ) : (
            <p style={{ color: '#aaa', gridColumn: '1/-1', textAlign: 'center', margin: '40px 0' }}>
              즐겨찾기한 영화가 없습니다. 하트를 눌러보세요!
            </p>
          )
        )}
      </div>
    </div>
  );
}