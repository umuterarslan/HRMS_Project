import React, { useState, useEffect } from "react";
import {
    Card,
    CardGroup,
    Image,
    Grid,
    Menu,
    Input,
    Icon,
    Radio,
} from "semantic-ui-react";
import { Link } from "react-router-dom";
import JobAdvertService from "../services/jobAdvertService";

export default function JobAdvertList() {
    let jobAdvertService = new JobAdvertService();

    const [jobAdverts, setJobAdverts] = useState([]);
    const [sort, setSort] = useState("");
    const [queryFilter, setQueryFilter] = useState("");

    useEffect(() => {
        jobAdvertService
            .getJobAdvertByIsActiveTrueAndIsConfirmedTrue()
            .then((success) => setJobAdverts(success.data.data));
    }, []);

    const descSort = () => {
        setSort("DESC");
        jobAdvertService
            .getJobAdvertByIsActiveTrueAndIsConfirmedTrueSorted(true)
            .then((success) => setJobAdverts(success.data.data))
            .catch((error) => console.log(error));
    };

    const ascSort = () => {
        setSort("ASC");
        jobAdvertService
            .getJobAdvertByIsActiveTrueAndIsConfirmedTrueSorted(false)
            .then((success) => setJobAdverts(success.data.data))
            .catch((error) => console.log(error));
    };

    function search(jobAdverts) {
        return jobAdverts.filter(
            (jobAdvert) =>
                jobAdvert.employer.companyName
                    .toLowerCase()
                    .indexOf(queryFilter) > -1 ||
                jobAdvert.description.toLowerCase().indexOf(queryFilter) > -1 ||
                jobAdvert.jobPosition.jobTitle
                    .toLowerCase()
                    .indexOf(queryFilter) > -1
        );
    }

    return (
        <div>
            <Grid>
                <Grid.Row>
                    <Grid.Column width={4}>
                        <div className="find-job-filter">
                            <Menu vertical>
                                <Menu.Item>
                                    <Input
                                        type="text"
                                        placeholder="Search"
                                        onChange={(event) =>
                                            setQueryFilter(event.target.value)
                                        }
                                    />
                                </Menu.Item>
                                <Menu.Item>
                                    <Icon
                                        name="calendar outline"
                                        color="blue"
                                    />
                                    Tarihe Göre Sıralama
                                    <Menu.Menu>
                                        <Menu.Item>
                                            <Radio
                                                label="Önce en yeni"
                                                name="sortRadio"
                                                checked={sort === "DESC"}
                                                onClick={descSort}
                                            />
                                        </Menu.Item>
                                        <Menu.Item>
                                            <Radio
                                                label="Önce en eski"
                                                name="sortRadio"
                                                checked={sort === "ASC"}
                                                onClick={ascSort}
                                            />
                                        </Menu.Item>
                                    </Menu.Menu>
                                </Menu.Item>
                                <Menu.Item
                                    name="browse"
                                    // active={activeItem === "browse"}
                                    // onClick={this.handleItemClick}
                                >
                                    <Icon name="grid layout" />
                                    Empty
                                </Menu.Item>
                                <Menu.Item
                                    name="messages"
                                    // active={activeItem === "messages"}
                                    // onClick={this.handleItemClick}
                                >
                                    Empty
                                </Menu.Item>
                                <Menu.Item
                                    name="messages"
                                    // active={activeItem === "messages"}
                                    // onClick={this.handleItemClick}
                                >
                                    Empty
                                </Menu.Item>
                                <Menu.Item
                                    name="messages"
                                    // active={activeItem === "messages"}
                                    // onClick={this.handleItemClick}
                                >
                                    Empty
                                </Menu.Item>
                                <Menu.Item
                                    name="messages"
                                    // active={activeItem === "messages"}
                                    // onClick={this.handleItemClick}
                                >
                                    Empty
                                </Menu.Item>
                                <Menu.Item
                                    name="messages"
                                    // active={activeItem === "messages"}
                                    // onClick={this.handleItemClick}
                                >
                                    Empty
                                </Menu.Item>
                            </Menu>
                        </div>
                    </Grid.Column>
                    <Grid.Column width={1}>
                        <div
                            style={{
                                borderLeft: "solid 1px #b2bec3",
                                height: "100%",
                            }}
                        ></div>
                    </Grid.Column>
                    <Grid.Column width={11}>
                        <CardGroup>
                            {search(jobAdverts).map((jobAdvert) => (
                                <Card
                                    style={{ minWidth: "70%" }}
                                    as={Link}
                                    to={`/jobAdvertDetail/${jobAdvert.id}`}
                                    key={jobAdvert.id}
                                >
                                    <Card.Content
                                        style={{
                                            boxShadow:
                                                "0 6px 8px 0 rgba(0, 0, 0, 0.2)",
                                        }}
                                    >
                                        <Image
                                            floated="right"
                                            size="tiny"
                                            src={`${jobAdvert.employer.pictureUrl}`}
                                        />
                                        <Card.Header
                                            style={{ color: "#0984e3" }}
                                        >
                                            {jobAdvert.jobPosition.jobTitle}
                                        </Card.Header>
                                        <Card.Meta>
                                            {jobAdvert.city.cityName}
                                        </Card.Meta>
                                        <Card.Meta>
                                            {jobAdvert.employer.companyName}
                                        </Card.Meta>
                                        <Card.Description>
                                            {"Son Başvuru Tarihi: "}
                                            {jobAdvert.expireDate}{" "}
                                        </Card.Description>
                                    </Card.Content>
                                </Card>
                            ))}
                        </CardGroup>
                    </Grid.Column>
                </Grid.Row>
            </Grid>
        </div>
    );
}
