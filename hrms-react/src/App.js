import "./App.css";
import "semantic-ui-css/semantic.min.css";
import Navi from "./components/Navi";
import { FindJob } from "./components/FindJob";
import { Container } from "semantic-ui-react";
import { Footer } from "./components/Footer";

function App() {
    return (
        <div className="App">
                <Navi />
            <Container className="find-job-container">
                <FindJob />
            </Container>
            <div className="footer">
                <Footer />
            </div>
        </div>
    );
}

export default App;
