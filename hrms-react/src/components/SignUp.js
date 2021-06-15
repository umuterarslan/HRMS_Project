import React, { useState } from "react";
import { Button, Container } from "semantic-ui-react";
import SignUpEmployer from "./SingUpEmployer";
import SignUpJobSeeker from "./SignUpJobSeeker";

export default function SignUp() {
    const signUpButtons = {
        backgroundColor: "#fff",
        color: "#00a8ff",
        boxShadow: "0 2px 2px 2px rgba(0, 0, 0, 0.1)",
        border: "solid 2px #fff",
    };

    const [isJobSeeker, setIsJobSeeker] = useState(true);

    return (
        <div alignContent="center">
            <Container
                textAlign="center"
                style={{
                    width: "100%",
                }}
            >
                <h1
                    style={{
                        color: "#ffff",
                        textShadow: "#00a8ff 1px 3px 1px",
                        fontSize: "4rem",
                    }}
                >
                    Hangisisin?
                </h1>
                <Button.Group size="huge">
                    <Button
                        className="employer-jobseeker-button"
                        style={signUpButtons}
                        onClick={() => setIsJobSeeker(true)}
                    >
                        İş Arayan
                    </Button>
                    <Button.Or text="veya" />
                    <Button
                        className="employer-jobseeker-button"
                        style={signUpButtons}
                        onClick={() => setIsJobSeeker(false)}
                    >
                        İş Veren
                    </Button>
                </Button.Group>
            </Container>
            <Container
                // floated="center"
                // alignContent="center"
                style={{
                    marginTop: "1.5rem",
                    paddingLeft: "29rem",
                }}
            >
                {isJobSeeker ? <SignUpJobSeeker /> : <SignUpEmployer />}
            </Container>
        </div>
    );
}
