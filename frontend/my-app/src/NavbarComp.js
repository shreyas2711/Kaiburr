import React from 'react';
import {Navbar, Container, Nav} from 'react-bootstrap';
export default function NavbarComp() {
  return (
    <div>
        <Navbar bg="dark" data-bs-theme="dark">
        <Container>
          <Navbar.Brand href="/" style={{fontSize:'27px',fontFamily:'inherit'}}>Tasks</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="/">Home</Nav.Link>
            <Nav.Link href="/createtask">Create Task</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </div>
  )
}
