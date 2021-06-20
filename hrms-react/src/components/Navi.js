import React from "react";
import { Container, Menu, Icon } from "semantic-ui-react";
import { Link } from "react-router-dom";

export default function Navi() {
    return (
        <div className="nav-bar">
            <Menu
                borderless
                size="huge"
                fixed="top"
                style={{
                    backgroundColor: "#0652dd",
                    transition: "all 0.5s linear 0.5",
                    borderBottom: "solid 2px grey",
                    borderTop: "solid 2px grey",
                }}
            >
                <Container>
                    <Menu.Item as={Link} to="/findJob">
                        <p>
                            İş Bul <Icon disabled name="search" color="black" />{" "}
                        </p>
                    </Menu.Item>
                    <Menu.Item as={Link} to="/findJob">
                        <p>
                            İş Bul <Icon disabled name="search" color="black" />
                        </p>
                    </Menu.Item>
                    <Menu.Item position="right" as={Link} to="/signin">
                        <p>
                            Giriş Yap
                            <p
                                style={{
                                    fontSize: "13px",
                                    marginTop: "5px",
                                    textAlign: "center",
                                }}
                            >
                                veya üye ol
                            </p>
                        </p>
                    </Menu.Item>
                </Container>
            </Menu>
        </div>
    );
}
