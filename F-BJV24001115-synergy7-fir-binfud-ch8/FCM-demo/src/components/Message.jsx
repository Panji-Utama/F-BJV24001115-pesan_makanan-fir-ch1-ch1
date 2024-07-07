const Message = ({ notification }) => {
  // Check if notification is defined and has the necessary properties
  if (!notification || !notification.title || !notification.body) {
    return null; // Or render a placeholder/loading component
  }

  return (
    <>
      <div id="notificationHeader">
        {/* image is optional */}
        {/* {notification.image && (
          <div id="imageContainer">
            <img src={notification.image} width={100} alt="Notification Image" />
          </div>
        )} */}
        <span>{notification.title}</span>
      </div>
      <div id="notificationBody">{notification.body}</div>
    </>
  );
};

export default Message;
