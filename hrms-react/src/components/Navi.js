import React from "react";
import { Container, Menu, Button } from "semantic-ui-react";

export default function Navi() {
    return (
        <div>
            <Menu
                size="huge"
                fixed="top"
                style={{
                    boxShadow: "0 2px 0 0 rgba(0, 0, 0, 0.2)",
                }}
            >
                <Container>
                    <Menu.Item
                        name="İş İlanları"
                        // active={activeItem === "home"}
                        // onClick={this.handleItemClick}
                    >
                        <Button>Ana Sayfa</Button>
                    </Menu.Item>
                    <Menu.Item
                        name="İş İlanları"
                        // active={activeItem === "messages"}
                        // onClick={this.handleItemClick}
                    />
                    <Menu.Item position="right">
                        <Button
                            style={{
                                backgroundColor: "#fff",
                                border: "solid 1.5px #00a8ff",
                                color: "#00a8ff",
                            }}
                        >
                            Sign In
                        </Button>
                    </Menu.Item>
                </Container>
            </Menu>
        </div>
    );
}
