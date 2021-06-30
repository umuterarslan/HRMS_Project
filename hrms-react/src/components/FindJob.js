// import React, { useState, useEffect } from "react";
// import { Card, CardGroup, Image } from "semantic-ui-react";
// import { Grid } from "semantic-ui-react";
// import { Link } from "react-router-dom";
// import JobAdvertService from "../services/jobAdvertService";

// export const FindJob = () => {
//     const [jobAdverts, setJobAderts] = useState([]);

//     useEffect(() => {
//         let jobAdvertService = new JobAdvertService();
//         jobAdvertService
//             .getJobAdverts()
//             .then((success) => setJobAderts(success.data.data));
//     }, []);

//     return (
//         <div>
//             <Grid>
//                 <Grid.Row>
//                     <Grid.Column width={4}></Grid.Column>
//                     <Grid.Column width={12}>
//                         <CardGroup>
//                             {jobAdverts.map((jobAdvert) => (
//                                 <Card style={{ minWidth: "70%" }}>
//                                     <Card.Content
//                                         style={{
//                                             boxShadow:
//                                                 "0 6px 8px 0 rgba(0, 0, 0, 0.2)",
//                                         }}
//                                     >
//                                         <Image
//                                             floated="right"
//                                             size="tiny"
//                                             src="https://react.semantic-ui.com/images/avatar/large/steve.jpg"
//                                         />
//                                         <Card.Header>
//                                             <Link
//                                                 to={`/jobAdvertDetail/${jobAdvert.id}`}
//                                             >
//                                                 {jobAdvert.jobPosition.jobTitle}
//                                             </Link>
//                                         </Card.Header>
//                                         <Card.Meta>
//                                             {jobAdvert.city.cityName}
//                                         </Card.Meta>
//                                         <Card.Meta>
//                                             {jobAdvert.employer.companyName}
//                                         </Card.Meta>
//                                         <Card.Description>
//                                             {jobAdvert.expireDate}
//                                         </Card.Description>
//                                     </Card.Content>
//                                 </Card>
//                             ))}
//                         </CardGroup>
//                     </Grid.Column>
//                 </Grid.Row>
//             </Grid>
//         </div>
//     );
// };

// export default FindJob();
