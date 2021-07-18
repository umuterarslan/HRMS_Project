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
import Select from "react-select";
import JobAdvertService from "../services/jobAdvertService";

export default function JobAdvertList() {
    const jobAdvertService = new JobAdvertService();

    const pageSizes = [
        { value: 10, label: "10 adet" },
        { value: 20, label: "20 adet" },
        { value: 50, label: "50 adet" },
        { value: 100, label: "100 adet" },
    ];

    const [jobAdverts, setJobAdverts] = useState([]);
    const [sort, setSort] = useState("");
    const [queryFilter, setQueryFilter] = useState("");
    const [pageSize, setPageSize] = useState(10);

    useEffect(() => {
        setPageSize(10);
        jobAdvertService
            .getActiveJobAdvertsSortedDesc(pageSize)
            .then((success) => setJobAdverts(success.data.data));
    }, []);

    const descSort = () => {
        setSort("DESC");
        jobAdvertService
            .getActiveJobAdvertsSortedDesc(pageSize)
            .then((success) => setJobAdverts(success.data.data))
            .catch((error) => console.log(error));
    };

    const ascSort = () => {
        setSort("ASC");
        jobAdvertService
            .getActiveJobAdvertsSortedAsc(pageSize)
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

    const sizeHandler = (e) => {
        setPageSize(e.value);
    };

    console.log(pageSize);

    return (
        <div>
            <Grid>
                <Grid.Row>
                    <Grid.Column width={4}>
                        <div className="find-job-filter">
                            <Menu vertical style={{ width: "100%" }}>
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
                                    <Select
                                        placeholder="Sayfadaki ilan sayısı"
                                        options={pageSizes}
                                        onChange={sizeHandler}
                                    ></Select>
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
