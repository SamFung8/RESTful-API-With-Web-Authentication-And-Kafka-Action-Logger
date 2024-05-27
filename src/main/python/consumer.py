from kafka import KafkaConsumer
import logging
import os
from datetime import datetime


consumer = KafkaConsumer('user-action', group_id= 'group2', bootstrap_servers= ['localhost:9092'], api_version=(0,10,2))


for msg in consumer:
    #print(msg)
    
    log_dir = '../user_action_log'
    log_file = os.path.join(log_dir, f'Web-app_{datetime.now().strftime("%Y%m%d_%H%M%S")}.log')

    logging.basicConfig(
        filename=log_file,
        level=logging.INFO,
        format='%(asctime)s - %(levelname)s - %(message)s',
        datefmt='%Y-%m-%d %H:%M:%S',
        filemode='w'  # Set the file mode to 'append'
    )

    # Example usage
    userName = msg.key.decode("utf-8")  # Decode the byte-encoded username
    action = msg.value.decode("utf-8")
    text = f"{datetime.now().strftime('%Y%m%d_%H%M%S')}\tUser={userName}\t{action}"
    logging.info(text)