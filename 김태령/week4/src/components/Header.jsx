import { Link } from "react-router-dom";

function Header() {
  return (
    <header className="navbar">
      <div
        className="nav-container"
        style={{
          textAlign: "center",
          color: "#333",
          marginBottom: "40px",
        }}
      >
        {/* 로고 클릭 시 메인으로 이동 */}
        <h1 className="logo">
          <Link to='/' style={{ textDecoration: "none", color: "inherit" }}>
            🎬 Movie Log
          </Link>
        </h1>
      </div>
    </header>
  );
}

export default Header;